package com.mvi.domain.model.example

import kotlinx.serialization.Serializable

@Serializable
data class SupportDto(
    val text: String,
    val url: String
)