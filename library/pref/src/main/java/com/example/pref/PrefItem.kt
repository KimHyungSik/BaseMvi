package com.example.pref

import com.example.pref.manager.PrefStrategy

data class PrefItem<T>(
    val key: String,
    val defaultValue: T,
    val prefStrategy: PrefStrategy
)
