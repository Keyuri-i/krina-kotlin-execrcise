package com.example.basicprogram

    // function to print spaces
    fun printSpace(i: Int) {
        // base case
        if (i == 0) return
        print(" ")
        printSpace(i - 1)
    }

    // function to print asterisks
    fun printStar(asterisk: Int) {
        // base case
        if (asterisk == 0) return
        print("* ")

        // recursively calling printStar()
        printStar(asterisk - 1)
    }

    // function to print the pattern
    fun pattern(n: Int, num: Int) {
        // base case
        if (n == 0) return
        printSpace(n - 1)
        printStar(num - n + 1)
        println("")

        // recursively calling pattern()
        pattern(n - 1, num)
    }

    // Driver code
    fun main() {
        val n = 5
        pattern(n, n)
    }
