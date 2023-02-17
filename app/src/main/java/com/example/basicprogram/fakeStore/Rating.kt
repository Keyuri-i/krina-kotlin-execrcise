package com.example.basicprogram.fakeStore

import java.io.Serializable

data class Rating(
    val count: Int,
    val rate: Double
) : Serializable