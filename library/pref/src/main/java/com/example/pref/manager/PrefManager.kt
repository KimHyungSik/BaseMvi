package com.example.pref.manager

import android.content.Context
import com.example.pref.PrefItem
import com.example.pref.datastore.DataStoreItem
import com.example.pref.memory.MemoryPrefItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf

class PrefManager(
    private val appContext: Context,
    private val domainName: String
) {
    private val dataStoreItem: PrefItem = DataStoreItem(appContext, domainName)
    private val memoryPrefItem: PrefItem = MemoryPrefItem()
    suspend fun <T> putData(key: String, data: T, strategy: PrefStrategy) {
        getPrefItem(strategy).forEach {
            it.put(key, data)
        }
    }

    suspend fun <T> getData(key: String, defaultValue: T): Flow<T> {
        val memoryResult = memoryPrefItem.get(key, defaultValue).first()
        return if (memoryResult == defaultValue) {
            dataStoreItem.get(key, defaultValue)
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
        PrefStrategy.MEMORY_ONLY -> listOf(memoryPrefItem)
        PrefStrategy.FILE_ONLY -> listOf(dataStoreItem)
        PrefStrategy.BOTH_MEMORY_AND_FILE -> listOf(memoryPrefItem, dataStoreItem)
    }
}