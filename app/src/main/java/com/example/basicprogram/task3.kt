package com.example.basicprogram

import java.util.*

// Matrix Prog 3*3

// Main function, Entry Point of Program
fun main() {

    //Input Stream
    val scanner = Scanner(System.`in`)

    //Input no of rows and column
    println("Enter the value of matrix ")

    //Create Array
    val matrixA = Array(3) { IntArray(3) }

    //Input Matrix
    for (rows in matrixA.indices) {
        for (column in matrixA[rows].indices) {
            print("[$rows][$column]: ")
            matrixA[rows][column] = scanner.nextInt()
        }
    }

    //print Matrix
    for (rows in matrixA.indices) {

        println("${matrixA[rows].contentToString()}")
    }
}

