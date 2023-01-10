package com.example.basicprogram

import java.util.Scanner

//Factorial of num

fun main(){

    val scanner=Scanner(System.`in`)
    print("Enter Number: ")
       val num=scanner.nextInt()
        var fact:Long=1
        for (i in 1..num){
            fact=fact*i
        }
    println("Factorial of $num = $fact")
}

//  Enter Number: 5
//  Factorial of 5 = 120