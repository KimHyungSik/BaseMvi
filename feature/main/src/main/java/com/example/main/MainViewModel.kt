package com.example.main

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.example.ExampleUseCase
import com.example.mvi.base.MviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val exampleUseCase: ExampleUseCase
) : MviViewModel<MainIntent.MainMviIntent, MainIntent.MainState, MainIntent.Effect>() {
    private fun callApi() {
        viewModelScope.launch {
            exampleUseCase.getExample()
                .collect {
                    Log.d("LOGEE", "init: $it")
                    emitIntent(MainIntent.MainMviIntent.GetExample(it))
                }
        }
    }

    override fun createInitialState(): MainIntent.MainState = MainIntent.MainState(false)

    override fun handleIntent() {
        subscribeIntent<MainIntent.MainMviIntent.CallExample> {
            callApi()
        }
        subscribeStateIntent<MainIntent.MainMviIntent.Loading> { state, _ ->
            state.copy(isLoading = false)
        }
        subscribeStateIntent<MainIntent.MainMviIntent.GetExample> { state, intent ->
            state.copy(isLoading = true)
        }
    }
}