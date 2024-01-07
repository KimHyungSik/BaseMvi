package com.example.pref.manager

import android.content.Context
import com.example.pref.Pref
import com.example.pref.PrefItem
import com.example.pref.datastore.DataStorePref
import com.example.pref.memory.MemoryPref
import kotlin.reflect.KClass

open class PrefManager(
    private val appContext: Context,
    private val domainName: String
) {
    private val dataStorePref: Pref = DataStorePref(appContext, domainName)
    private val memoryPref: Pref = MemoryPref()

    fun <T> createPrefItem(key: String, defaultValue: T, type: KClass<*>) =
        PrefItem(
            key = key,
            defaultValue = defaultValue,
            prefStrategy = PrefStrategy.BOTH_MEMORY_AND_FILE,
            dataStorePref = dataStorePref,
            memoryPref = memoryPref,
            type = type,
        )

    fun <T> createMemoryPrefItem(key: String, defaultValue: T, type: KClass<*>) =
        PrefItem(
            key = key,
            defaultValue = defaultValue,
            prefStrategy = PrefStrategy.MEMORY_ONLY,
            dataStorePref = dataStorePref,
            memoryPref = memoryPref,
            type = type,
        )

    fun <T> createPreferencePrefItem(key: String, defaultValue: T, type: KClass<*>) =
        PrefItem(
            key = key,
            defaultValue = defaultValue,
            prefStrategy = PrefStrategy.FILE_ONLY,
            dataStorePref = dataStorePref,
            memoryPref = memoryPref,
            type = type,
        )
}