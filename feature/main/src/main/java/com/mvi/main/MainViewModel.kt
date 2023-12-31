package com.mvi.main

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.di.qualifier.GlobalPref
import com.example.pref.PrefItem
import com.example.pref.datastore.DataStoreItem
import com.example.pref.manager.PrefManager
import com.example.pref.manager.PrefStrategy
import com.mvi.account.AccountManagerHelper
import com.mvi.domain.usecase.example.ExampleUseCase
import com.mvi.mvi.base.MviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOn
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
            prefManager.putData("Int", 1, PrefStrategy.FILE_ONLY)
            prefManager.putData("String", "String", PrefStrategy.MEMORY_ONLY)
            prefManager.putData("Boolean", true, PrefStrategy.MEMORY_ONLY)
            prefManager.putData("Long", 1L, PrefStrategy.MEMORY_ONLY)

            prefManager.getData("Int", 2).first {
                Log.d("LOGEE", "callApi: Int $it")
                true
            }
            prefManager.getData("String", "String2").first {
                Log.d("LOGEE", "callApi: String $it")
                true
            }
            prefManager.getData("Boolean", false).first {
                Log.d("LOGEE", "callApi: Boolean $it")
                true
            }
            prefManager.getData("Long", 2L).first {
                Log.d("LOGEE", "callApi: Long $it")
                true
            }
            launch {
                prefManager.getData("Int", 2).flowOn(Dispatchers.IO).collect {
                    Log.d("LOGEE", "Int: $it")
                }
            }
            Log.d("LOGEE", ":")
            prefManager.getData("Int", 7)
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