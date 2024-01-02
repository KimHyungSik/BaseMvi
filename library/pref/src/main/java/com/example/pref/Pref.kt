package com.example.pref

import kotlinx.coroutines.flow.Flow

interface Pref {
    suspend fun <T> get(key: String, defaultValue: T): Flow<T>
    suspend fun <T> put(key: String, data: T)
    suspend fun clear(key: String)
    suspend fun clearAll()
}