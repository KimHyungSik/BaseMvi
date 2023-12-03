package com.example.main

import com.example.domain.model.example.ExampleDataDto
import com.example.mvi.mvi.MviIntent
import com.example.mvi.mvi.SideEffect
import com.example.mvi.mvi.UiState

class MainIntent {
    sealed interface MainMviIntent: MviIntent {
        data object Loading: MainMviIntent
        data object CallExample: MainMviIntent
        data class GetExample(
            val exampleDataDto: ExampleDataDto
        ): MainMviIntent
    }

    data class MainState(
        val isLoading: Boolean
    ): UiState

    sealed class Effect: SideEffect{

    }
}