package com.example.pref.manager

import android.content.Context
import com.example.pref.Pref
import com.example.pref.PrefItem
import com.example.pref.datastore.DataStore
import com.example.pref.memory.MemoryPref
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf

open class PrefManager(
    private val appContext: Context,
    private val domainName: String
) {
    private val dataStorePref: Pref = DataStore(appContext, domainName)
    private val memoryPref: Pref = MemoryPref()
    suspend fun <T> PrefItem<T>.putData(data: T) {
        getPrefItem(prefStrategy).forEach {
            it.put(key, data)
        }
    }

    suspend fun <T> PrefItem<T>.getData(): Flow<T> {
        val memoryResult = memoryPref.get(key, defaultValue).first()
        return if (memoryResult == defaultValue) {
            dataStorePref.get(key, defaultValue)
        } else {
            flowOf(memoryResult)
        }
    }

    suspend fun clear(key: String, strategy: PrefStrategy) {
        getPrefItem(strategy).forEach {
            it.clear(key)
        }
    }

    suspend fun clearAll(key: String, strategy: PrefStrategy) {
        getPrefItem(strategy).forEach {
            it.clearAll()
        }
    }

    private fun getPrefItem(strategy: PrefStrategy) = when (strategy) {
        PrefStrategy.MEMORY_ONLY -> listOf(memoryPref)
        PrefStrategy.FILE_ONLY -> listOf(dataStorePref)
        PrefStrategy.BOTH_MEMORY_AND_FILE -> listOf(memoryPref, dataStorePref)
    }
}