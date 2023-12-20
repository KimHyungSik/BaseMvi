package com.example.pref.datastore

import android.content.Context
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStoreFile

open class DataStoreItem(
    private val context: Context,
    private val domain: String
) {

    private val dataStore = PreferenceDataStoreFactory.create {
        context.preferencesDataStoreFile(domain)
    }

    suspend fun <T> put(key: String, data: T) {
        when (data) {
            is Int -> putInt(key, data)
            is Long -> putLong(key, data)
            is Float -> putFloat(key, data)
            is Boolean -> putBoolean(key, data)
            is Double -> putDouble(key, data)
            is String -> putString(key, data)
        }
    }

    private suspend fun putInt(key: String, data: Int) {
        val intKey = intPreferencesKey(key)
        dataStore.edit { preferences ->
            preferences[intKey] = data
        }
    }

    private suspend fun putLong(key: String, data: Long) {
        val longKey = longPreferencesKey(key)
        dataStore.edit { preferences ->
            preferences[longKey] = data
        }
    }

    private suspend fun putFloat(key: String, data: Float) {
        val floatKey = floatPreferencesKey(key)

        dataStore.edit { preferences ->
            preferences[floatKey] = data
        }
    }

    private suspend fun putBoolean(key: String, data: Boolean) {
        val booleanKey = booleanPreferencesKey(key)
        dataStore.edit { preferences ->
            preferences[booleanKey] = data
        }
    }

    private suspend fun putDouble(key: String, data: Double) {
        val doubleKey = doublePreferencesKey(key)
        dataStore.edit { preferences ->
            preferences[doubleKey] = data
        }
    }

    private suspend fun putString(key: String, data: String) {
        val stringKey = stringPreferencesKey(key)
        dataStore.edit { preferences ->
            preferences[stringKey] = data
        }
    }
}