package com.mvi.main

import android.util.Log
import com.mvi.account.AccountManagerHelper
import com.mvi.mvi.base.MviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val accountManagerHelper: AccountManagerHelper
) : MviViewModel<MainIntent.MainMviIntent, MainIntent.MainState, MainIntent.Effect>() {

    private fun removeToken(){
        accountManagerHelper.removeAuthToken()
    }
    private fun callApi(email: String, token: String) {
        accountManagerHelper.setAuthToken(
            email = email,
            password = null,
            token = token
        )
        accountManagerHelper.getAccount()?.let {
            emitIntent(MainIntent.MainMviIntent.GetToken(it.name))
        }
    }

    override fun createInitialState(): MainIntent.MainState = MainIntent.MainState(
        isLoading = false,
        isSuccessSetToken = false,
    )

    override fun handleIntent() {
        subscribeIntent<MainIntent.MainMviIntent.SetToken> {
            callApi(it.email, it.token)
        }
        subscribeIntent<MainIntent.MainMviIntent.RemoveToken> {
            removeToken()
        }
        subscribeStateIntent<MainIntent.MainMviIntent.Loading> { state, _ ->
            state.copy(isLoading = false)
        }
        subscribeStateIntent<MainIntent.MainMviIntent.GetToken> { state, intent ->
            state.copy(isLoading = true)
        }
    }
}