package com.example.pref.memory

import com.example.pref.Pref
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update


class MemoryPref : Pref {

    private val _memoryPref = MutableStateFlow<MutableMap<String, Any?>>(mutableMapOf())
    private val memoryPref: StateFlow<MutableMap<String, Any?>> get() = _memoryPref

    @Suppress("UNCHECKED_CAST")
    override suspend fun <T> get(key: String, defaultValue: T): Flow<T> =
        memoryPref.map { it[key] as? T ?: defaultValue }

    override suspend fun <T> put(key: String, data: T) {
        val map = _memoryPref.value
        map[key] = data
        _memoryPref.update { map }
    }

    override suspend fun clear(key: String) {
        val map = _memoryPref.value
        map.remove(key)
        _memoryPref.update { map }
    }

    override suspend fun clearAll() {
        val map = _memoryPref.value
        map.clear()
        _memoryPref.update { map }
    }
}