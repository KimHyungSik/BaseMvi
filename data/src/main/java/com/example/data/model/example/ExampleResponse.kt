package com.example.domain.model.example

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExampleResponse(
    @SerialName("data") val dataList: List<Data>,
    val page: Int,
    val per_page: Int,
    val support: Support,
    val total: Int,
    val total_pages: Int
)

fun ExampleResponse.toDto() =
    ExampleDataDto(dataList.map { it.toDto() }, page, per_page, support.toDto(), total, total_pages)