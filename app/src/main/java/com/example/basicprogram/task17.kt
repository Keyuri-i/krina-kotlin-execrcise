package com.example.basicprogram

import kotlin.math.PI

fun main(){
    val triangle:Shape=Triangle()
    val a=triangle.area(10.0,5.0)
    println("Area of Triangle: $a")

    val circle:Shape=Circle()
    val b=circle.area(5.0,5.0)
    println("Area of Circle: $b")

    val rect:Shape=Rectangle()
    val c=rect.area(10.0,4.0)
    println("Area of Rectangle: $c")
    }


abstract class Shape{
    abstract fun area(w: Double, h: Double):Double
}

class Triangle:Shape(){
    override fun area(w: Double, h: Double): Double {
        return (w*h)/2
    }
}

class Circle:Shape(){
    override fun area(w: Double, h: Double): Double {
        val pi= 3.14
        return (pi*w*h)
    }
}

class Rectangle:Shape(){
    override fun area(w: Double, h: Double): Double {
        return w*h
    }
}