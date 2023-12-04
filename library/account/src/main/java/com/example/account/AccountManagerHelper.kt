package com.example.account

import android.accounts.Account
import android.accounts.AccountManager
import android.app.Activity
import android.os.Bundle

class AccountManagerHelper(
    private val accountManager: AccountManager,
    private val authKey: AuthenticatorKey
) {
    fun setAuthToken(email: String, token: String) {
        val account = Account(email, authKey.accountType)
        val accounts = accountManager.getAccountsByType(authKey.accountType)
        if(accounts.isEmpty()){
            accountManager.addAccountExplicitly(account, null, Bundle())
        }
        accountManager.setAuthToken(account, authKey.authTokenType, token)
    }
}