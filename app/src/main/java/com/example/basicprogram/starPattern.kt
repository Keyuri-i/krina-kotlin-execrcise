package com.example.basicprogram

fun main() {

    for (i in 1..5){
        for (j in i until 5){
            print("  ")
        }
        for (k in 1 until 2*i){
            print("* ")
        }
        println()
    }
}
