package com.mvi.account

import android.accounts.Account
import android.accounts.AccountManager
import android.os.Bundle
import android.util.Log

class AccountManagerHelper(
    private val accountManager: AccountManager,
    private val authKey: AuthenticatorKey
) {

    /**
     * Token 삭제.
     */
    fun removeAuthToken(){
        val account = getAuthToken() ?: return
        accountManager.removeAccountExplicitly(account)
    }

    /**
     * @return accountType 의로 찾은 첫번째 계정을 반환 한다.
     */
    fun getAuthToken(): Account? {
        val accounts = accountManager.getAccountsByType(authKey.accountType)
        if(accounts.isEmpty()){
            return null
        }
        return accounts.firstOrNull { it.type == authKey.accountType }
    }

    /**
     * @param email Account email.
     * @param password Account password 필수 적이지 않음.
     * @param token 저장할 토큰.
     */
    fun setAuthToken(email: String, password: String? = null, token: String) {
        val account = Account(email, authKey.accountType)
        val accounts = accountManager.getAccountsByType(authKey.accountType)
        if (accounts.isEmpty()) {
            accountManager.addAccountExplicitly(account, password, Bundle())
        }
        accountManager.setAuthToken(account, authKey.authTokenType, token)
    }
}