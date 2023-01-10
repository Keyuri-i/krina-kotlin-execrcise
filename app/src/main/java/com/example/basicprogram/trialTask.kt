package com.example.basicprogram
/*
package com.example.basicprogram

import android.nfc.tech.NfcA
import kotlinx.coroutines.processNextEventInCurrentThread

fun main(){
    val student=Student(5,"Joy",50.0,"M")
    val stu=Student(1,"Jack")
    val stu1=Student(7)


}

class Student( no:Int=2, _name: String="John", _marks:Double=70.0, _gender: String="M"){

    */
/*var number:Int
    val name:String
    var mark:Double
    val gender:String*//*

    var number=no
    val name=_name
    var mark=_marks
    val gender=_gender

    init {
        */
/* number=no
         name=_name
         mark=_marks
         gender=_gender*//*



        display()
    }

    private fun display() {
        println("Number is: $number")
        println("Name is: $name")
        println("Marks is: $mark")
        println("Gender is: $gender")
        println()
    }
}
*/

class Student1 {
    var name: String
    val age : Int

    constructor(name: String, age: Int)
    {
        this.name = name
        this.age = age
    }

    fun printDetails()
    {
        println("Name is $name and Age is $age")
    }

}

fun main(args: Array<String>) {

    var student = Student1("Anupam", 24)
    student.printDetails()
}