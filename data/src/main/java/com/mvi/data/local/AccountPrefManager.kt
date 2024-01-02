package com.mvi.data.local

import android.content.Context
import com.example.pref.manager.PrefManager
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AccountPrefManager @Inject constructor(
    @ApplicationContext private val context: Context,
) : PrefManager(context, ACCOUNT_PREF) {


    companion object {
        const val ACCOUNT_PREF = "accountPref"
    }
}