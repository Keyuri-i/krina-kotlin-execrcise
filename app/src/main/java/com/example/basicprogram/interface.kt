package com.example.basicprogram

interface Exam{
    fun pass(marks:Int):Boolean
}
interface Classify{
    fun division(average:Int):String
}

class Result:Exam,Classify {
    override fun pass(marks: Int): Boolean {
        return marks >= 50
    }


    override fun division(average: Int): String {
        if (average >= 60)
            return "First"

        else if (average in 50..59)
            return "Second"

        return "No Division"

    }
}


fun main(){
    val res=Result()
    println(res.pass(49))
    println(res.division(51))
    }
