package com.example.account

import android.accounts.Account
import android.accounts.AccountManager
import android.app.Activity
import android.os.Bundle

class AccountManagerHelper(
    private val accountManager: AccountManager,
    private val authKey: AuthKey
) {

    fun addAccount(activity: Activity) {
        val options = Bundle()
        accountManager.addAccount(
            authKey.accountType,
            authKey.authTokenType,
            null,
            options,
            activity,
            null,
            null
        )
    }

    fun setAuthToken(name: String, token: String) {
        val account = Account(name, authKey.accountType)
        accountManager.setAuthToken(account, authKey.authTokenType, token)
    }
}