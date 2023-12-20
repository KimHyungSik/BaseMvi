package com.mvi.data.model.example

import com.mvi.domain.model.example.DataDto
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val avatar: String,
    val email: String,
    val first_name: String,
    val id: Int,
    val last_name: String
)
 fun Data.toDto() = DataDto(avatar, email, first_name, id, last_name)