package com.example.basicprogram

import java.util.*

//Add Two Matrices

// Main function, Entry Point of Program
fun main() {

    //Input Stream
    val scanner = Scanner(System.`in`)

    //Create Array
    val matrixA = Array(3) { IntArray(3) }

    val matrixB = Array(3) { IntArray(3)}

    val matrixSum=Array(3) {IntArray(3)}

    //Input MatrixA
    println("Enter the value of matrixA ")
    for (row in matrixA.indices) {
        for (column in matrixA[row].indices) {
            print("[$row][$column]: ")
            matrixA[row][column] = scanner.nextInt()
        }
    }

    //print MatrixA
    for (rows in matrixA.indices) {
        println("${matrixA[rows].contentToString()}")
    }

    //Input MatrixB
    println("Enter the value of matrixB ")
    for (row in matrixB.indices) {
        for (column in matrixB[row].indices) {
            print("[$row][$column]: ")
            matrixB[row][column] = scanner.nextInt()
        }
    }

    //print MatrixB
    for (row in matrixB.indices) {
        println("${matrixB[row].contentToString()}")
    }

    //Addition
    for (row in matrixSum.indices){
        for (column in matrixSum[row].indices){
            matrixSum[row][column]=matrixA[row][column] + matrixB[row][column]
        }
    }

    //Print Sum
    println("Sum of Matrices")
    for (row in matrixSum.indices) {
       println("${matrixSum[row].contentToString()}")
    }

}

