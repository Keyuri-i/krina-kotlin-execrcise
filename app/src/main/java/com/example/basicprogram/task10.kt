package com.example.basicprogram

import java.util.Scanner

// Recursion

fun main(){
    val scanner=Scanner(System.`in`)
    print("Enter Number: ")
    val num= scanner.nextInt()
    val fact=multipleNum(num)
    println("Factorial recursive $num = $fact")
}

fun multipleNum(num: Int): Int {
        if (num>=1){
            return  num * multipleNum(num-1)
        }
    else return 1
}


//  Enter Number: 4
//  Factorial recursive 4 = 24