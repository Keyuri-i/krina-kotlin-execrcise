package com.example.basicprogram

//Interface

fun main(){
    val demo=Demo()
    demo.add(5,15)
    demo.sub(15,5)
}

//create interface
interface Sum{
    fun add(a: Int,b: Int)
    fun sub(a:Int,b: Int)
}

//override fun
class Demo:Sum{
    override fun add(a:Int,b:Int) {
        val x=a+b
        println("Sum is $x")
    }

    override fun sub(a: Int,b: Int) {
        val x=a-b
        println("Sub is $x")
    }
}

//  Sum is 20
//  Sub is 10