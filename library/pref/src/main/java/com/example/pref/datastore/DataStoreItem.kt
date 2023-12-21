package com.example.pref.datastore

import android.content.Context
import androidx.datastore.preferences.core.MutablePreferences
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStoreFile
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
import kotlin.reflect.KClass

open class DataStoreItem(
    private val context: Context,
    private val domain: String
) {

    val keyType: MutableMap<String, KClass<*>> = mutableMapOf()

    val dataStore = PreferenceDataStoreFactory.create {
        context.preferencesDataStoreFile(domain)
    }

    suspend inline fun <reified T> get(key: String, defaultValue: T): Flow<T> {
        val valueClass = keyType[key] ?: return flowOf(defaultValue)

        return dataStore.data
            .catch { exception ->
                emit(emptyPreferences())
            }
            .map { preferences ->
                when (valueClass) {
                    Int::class -> preferences[intPreferencesKey(key)]
                    Long::class -> preferences[longPreferencesKey(key)]
                    Float::class -> preferences[floatPreferencesKey(key)]
                    Boolean::class -> preferences[booleanPreferencesKey(key)]
                    Double::class -> preferences[doublePreferencesKey(key)]
                    String::class -> preferences[stringPreferencesKey(key)]
                    else -> {
                        val json = preferences[stringPreferencesKey(key)]
                        if (json != null) {
                            Json.decodeFromString<T>(json)
                        } else {
                            null
                        }
                    }
                } as? T ?: defaultValue
            }
    }

    suspend inline fun <reified T> put(key: String, data: T) {
        when (data) {
            is Int -> safeDataStoreOperation<Int>(key) { preferences ->
                preferences[intPreferencesKey(key)] = data
            }

            is Long -> safeDataStoreOperation<Long>(key) { preferences ->
                preferences[longPreferencesKey(key)] = data
            }

            is Float -> safeDataStoreOperation<Float>(key) { preferences ->
                preferences[floatPreferencesKey(key)] = data
            }

            is Boolean -> safeDataStoreOperation<Boolean>(key) { preferences ->
                preferences[booleanPreferencesKey(key)] = data
            }

            is Double -> safeDataStoreOperation<Double>(key) { preferences ->
                preferences[doublePreferencesKey(key)] = data
            }

            is String -> safeDataStoreOperation<String>(key) { preferences ->
                preferences[stringPreferencesKey(key)] = data
            }

            else -> {
                val serializedData = serializable(data)
                safeDataStoreOperation<String>(key) { preferences ->
                    preferences[stringPreferencesKey(key)] = serializedData
                }
            }
        }
    }

    inline fun <reified T> serializable(data: T): String {
        return try {
            Json.encodeToString(data)
        } catch (e: Exception) {
            throw DataStoreException("Failed to serialize data", e)
        }
    }

    suspend inline fun <reified T> safeDataStoreOperation(
        key: String,
        crossinline operation: (preferences: MutablePreferences) -> Unit
    ) {
        try {
            dataStore.edit { preferences ->
                operation(preferences)
            }
            keyType[key] = T::class
        } catch (e: Exception) {
            throw DataStoreException(key, e)
        }
    }
}