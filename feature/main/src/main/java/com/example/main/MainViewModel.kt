package com.example.main

import com.example.account.AccountManagerHelper
import com.example.domain.usecase.example.ExampleUseCase
import com.example.mvi.base.MviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val accountManagerHelper: AccountManagerHelper
) : MviViewModel<MainIntent.MainMviIntent, MainIntent.MainState, MainIntent.Effect>() {
    private fun callApi(email: String, token: String) {
        accountManagerHelper.setAuthToken(email, token)
    }

    override fun createInitialState(): MainIntent.MainState = MainIntent.MainState(
        isLoading = false,
        isSuccessSetToken = false,
    )

    override fun handleIntent() {
        subscribeIntent<MainIntent.MainMviIntent.SetToken> {
            callApi(it.email, it.token)
        }
        subscribeStateIntent<MainIntent.MainMviIntent.Loading> { state, _ ->
            state.copy(isLoading = false)
        }
        subscribeStateIntent<MainIntent.MainMviIntent.GetToken> { state, intent ->
            state.copy(isLoading = true)
        }
    }
}