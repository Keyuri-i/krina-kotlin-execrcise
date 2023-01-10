package com.example.basicprogram

import java.util.Scanner

//Calculator Functionality

fun main(){
    val scanner=Scanner(System.`in`)

    print("Enter value of a:")
    val a=scanner.nextDouble()

    print("Enter value of b:")
    val b=scanner.nextDouble()

    println("Select Any of this Action (Add,Sub,Multi,Div): ")
    var choice=-1

    do {
        println("1. Add")
        println("2. Sub")
        println("3. Multi")
        println("4. Div")
        print("Enter Your Choice =")
        choice = scanner.nextInt()

        when (choice) {
            1 -> println("Addition is: ${a + b}")
            2 -> println("Subtraction is: ${a - b}")
            3 -> println("Multiplication is: ${a * b}")
            4 -> println("Division is: ${a / b}")

         else -> {
             println("Error! Please enter correct choice")
             return
         }
        }
    }while (choice != 0)
}


//  Enter value of a:5
//  Enter value of b:10
//  Select Any of this Action (Add,Sub,Multi,Div):
//  1. Add
//  2. Sub
//  3. Multi
//  4. Div
//  Enter Your Choice =4
//  Division is: 0.5
//  1. Add
//  2. Sub
//  3. Multi
//  4. Div
//  Enter Your Choice =