package com.example.basicprogram

//Inheritance

fun main(){
    val ad=AndroidDeveloper(25,"John",30000)
    ad.android()

    val iosDeveloper=IosDeveloper(20,"Jack",20000)
    iosDeveloper.developer()
}

//base class
open class Employee(age:Int ,name:String,salary:Int){
    init {
        println("My name is $name ,$age year old and my salary is $salary")
    }
}

//derived class
class AndroidDeveloper(age: Int,name: String,salary: Int):Employee(age, name, salary) {
    fun android(){
        println("I am Android Developer")
        println()
    }
}
class IosDeveloper(age: Int,name: String,salary: Int):Employee(age, name, salary) {
    fun developer(){
        println("I am Ios app Developer")
        println()
    }
}

//  My name is John ,25 year old and my salary is 30000
//  I am Android Developer

//  My name is Jack ,20 year old and my salary is 20000
//  I am Ios app Developer
