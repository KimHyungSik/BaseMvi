package com.mvi.data.local

import android.content.Context
import com.example.pref.manager.PrefManager
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GlobalPrefManager @Inject constructor(
    @ApplicationContext private val context: Context,
) : PrefManager(context, DEVICE_PREF) {

    val globalSample = createPreferencePrefItem("globalSample", "String2", String::class)

    companion object {
        const val DEVICE_PREF = "devicePref"
    }
}