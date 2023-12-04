package com.example.main

import com.example.domain.model.example.ExampleDataDto
import com.example.mvi.mvi.MviIntent
import com.example.mvi.mvi.SideEffect
import com.example.mvi.mvi.UiState

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