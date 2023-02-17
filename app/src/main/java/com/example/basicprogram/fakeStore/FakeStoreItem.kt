package com.example.basicprogram.fakeStore

import java.io.Serializable

data class FakeStoreItem(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    var price: Double,
    val rating: Rating,
    val title: String
) : Serializable
