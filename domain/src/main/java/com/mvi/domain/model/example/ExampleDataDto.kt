package com.mvi.domain.model.example

data class ExampleDataDto(
    val dataList: List<DataDto>,
    val page: Int,
    val per_page: Int,
    val support: SupportDto,
    val total: Int,
    val total_pages: Int
)