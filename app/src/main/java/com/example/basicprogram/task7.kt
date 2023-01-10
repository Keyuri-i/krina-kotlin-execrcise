package com.example.basicprogram

//repeated word in string

fun main(){
    val str = "This is The Language of Kotlin and is the good one"
    println(str.groupingBy { it }.eachCount().filter { it.value >= 1 })
  //s  println(str.count { it == })
   /* val str = "This is abc is like fine sss like is not good like xyz like"
    val delim = " "

    val list = str.lowercase().split(delim)
    val list1 = list.groupBy {  it }
    val maxEntry = list1.maxWith(Comparator { x, y -> x.value.size.compareTo(y.value.size)})
    println(maxEntry.key)*/

   // println(str.groupingBy { it }.eachCount().filter { it.value >= 1 })
}


//   {T=2, h=3, i=4, s=3,  =10, e=4, L=1, a=3, n=4, g=3, u=1, o=5, f=1, K=1, t=2, l=1, d=2}