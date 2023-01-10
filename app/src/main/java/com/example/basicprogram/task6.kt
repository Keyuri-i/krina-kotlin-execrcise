package com.example.basicprogram

//Count Length of string
//Upper to lower and vice-versa

fun main() {
    val str = "Hii This Is Kotlin Language..12..3.4..hEllO"
    println(str)
    //val storeStr=""

    println("Length of String :${str.length}")


    //Convert String
    print("Convert String : ")
    //String Length
    for (c in str){
        when{
            c.isUpperCase() -> print(c.lowercaseChar())
            c.isLowerCase() -> print(c.uppercaseChar())
            else -> print(c)
        }
    }
}


//   Length of String :43
//   Convert String : hII tHIS iS kOTLIN lANGUAGE..12..3.4..HeLLo