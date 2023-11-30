package com.example.main

import com.example.mvi.mvi.MviIntent
import com.example.mvi.mvi.SideEffect
import com.example.mvi.mvi.UiState

class MainIntent {
    sealed interface MainMviIntent: MviIntent {
        data object Loading: MainMviIntent
        data object CallExample: MainMviIntent
        data object GetExample: MainMviIntent
    }

    data class MainState(
        val isLoading: Boolean
    ): UiState

    sealed class Effect: SideEffect
}