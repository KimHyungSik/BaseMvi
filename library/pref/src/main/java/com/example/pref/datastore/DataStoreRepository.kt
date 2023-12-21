package com.example.pref.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStoreRepository(
    private val preferencesDataStore: DataStore<Preferences>
){
    suspend fun<T> getExampleData(key: Preferences.Key<T>, defaultValue: T): Flow<T> = preferencesDataStore.data
        .map { preferences ->
            preferences[key] ?: defaultValue
        }
}