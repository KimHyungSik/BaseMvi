package com.mvi.domain.model.example

import kotlinx.serialization.Serializable

@Serializable
data class Support(
    val text: String,
    val url: String
)

fun Support.toDto() = SupportDto(text, url)