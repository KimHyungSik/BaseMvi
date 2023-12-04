package com.mvi.main

import com.mvi.mvi.mvi.MviIntent
import com.mvi.mvi.mvi.SideEffect
import com.mvi.mvi.mvi.UiState

class MainIntent {
    sealed interface MainMviIntent : MviIntent {
        data object Loading : MainMviIntent
        data class SetToken(
            val email: String,
            val token: String
        ) : MainMviIntent

        data object GetToken : MainMviIntent
    }

    data class MainState(
        val isLoading: Boolean,
        val isSuccessSetToken: Boolean,
        val token: String? = null
    ) : UiState

    sealed class Effect : SideEffect {

    }
}