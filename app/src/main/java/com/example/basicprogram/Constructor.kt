package com.example.basicprogram


fun main(){

    val student=Student(5,"abc",40.0,'a')
    student.display()
}

class Student(val no: Int, val name: String, val mark: Double, val gender: Char) {

   // val number:Int = no


    fun display() {
            println("Name is $name and number is $no and mark is $mark and gender is $gender")
    }
}


