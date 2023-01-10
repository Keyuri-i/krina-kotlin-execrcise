package com.example.basicprogram

//Overloading

fun main(){
        val op=Operation()
        op.Sum(2,10)
        op.Sum(5,5,5)
        op.Sum(5,6,8,2)
}

//Method Overloading
class Operation(){

    //same fun name & diff arg
    fun Sum(a:Int,b:Int){
        println("Sum of Two Number ($a,$b): ${a+b}")
    }

    fun Sum(a:Int,b:Int,c:Int){
        println("Sum of Three Number ($a,$b,$c): ${a+b+c}")
    }

    fun Sum(a:Int,b:Int,c:Int,d:Int){
        println("Sum of Four Number ($a,$b,$c,$d): ${a+b+c+d}")
    }
}


//  Sum of Two Number (2,10): 12
//  Sum of Three Number (5,5,5): 15
//  Sum of Four Number (5,6,8,2): 21