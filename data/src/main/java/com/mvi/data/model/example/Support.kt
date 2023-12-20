package com.mvi.data.model.example

import com.mvi.domain.model.example.SupportDto
import kotlinx.serialization.Serializable

@Serializable
data class Support(
    val text: String,
    val url: String
)

fun Support.toDto() = SupportDto(text, url)