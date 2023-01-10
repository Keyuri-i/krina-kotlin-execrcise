package com.example.basicprogram

// Convert ArrayList to Array nd vice-versa

fun main(){
    print("ArrayList to Array: ")
    val char:List<String> = listOf("a","b","c","d","e","f")
    val charArray: Array<String> = char.toTypedArray()
    charArray.forEach { print(it)  }

    println()
    print("Array to ArrayList: ")
    val charArray1:Array<String> = arrayOf("a","b","c","d","e","f")
    val char1: List<String> = charArray1.toList()
    char1.forEach { print(it) }
}



//  ArrayList to Array: abcdef
//  Array to ArrayList: abcdef