package com.example.domain.model.example

data class DataResponse(
    val avatar: String,
    val email: String,
    val first_name: String,
    val id: Int,
    val last_name: String
)

fun DataResponse.toDto() = Data(avatar, email, first_name, id, last_name,)