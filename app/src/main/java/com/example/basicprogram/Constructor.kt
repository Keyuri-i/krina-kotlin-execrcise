package com.example.basicprogram


fun main(){

    val student=Student(5,"abc",40,'m')
    student.display()
}

class Student(var no: Int, val name: String, var mark: Int, var gender: Char) {

    fun display() {
            println("Name is $name and number is $no and mark is $mark and gender is $gender")
    }
}


