package com.example.basicprogram.fakeStore

data class FakeStoreItem(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    var price: Double,
    val rating: Rating,
    val title: String
)


