package com.example.basicprogram

//remove duplicate in string

fun main(args: Array<String>) {
    val str = "geeksforgeeks".toCharArray()
    val dupli=str.distinct()
    println(dupli.toString())

}


//  [g, e, k, s, f, o, r]
