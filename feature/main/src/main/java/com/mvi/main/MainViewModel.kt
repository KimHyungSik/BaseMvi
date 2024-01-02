package com.mvi.main

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.di.qualifier.GlobalPref
import com.example.pref.manager.PrefManager
import com.mvi.account.AccountManagerHelper
import com.mvi.domain.usecase.example.ExampleUseCase
import com.mvi.mvi.base.MviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    @GlobalPref private val prefManager: PrefManager,
    private val exampleUseCase: ExampleUseCase,
    private val accountManagerHelper: AccountManagerHelper
) : MviViewModel<MainIntent.MainMviIntent, MainIntent.MainState, MainIntent.Effect>() {

    init {
        viewModelScope.launch {
        }
    }

    private fun removeToken() {
        accountManagerHelper.removeAuthToken()
    }

    private fun callApi(email: String, token: String) {
        viewModelScope.launch {
            exampleUseCase.getExample()
                .collect {
                    Log.d("LOGEE", "callApi: $it")
                }
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