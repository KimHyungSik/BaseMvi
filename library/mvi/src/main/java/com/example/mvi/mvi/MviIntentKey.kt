package com.example.mvi.mvi

data class MviIntentKey<T : MviIntent>(
    val clazz: Class<T>
)