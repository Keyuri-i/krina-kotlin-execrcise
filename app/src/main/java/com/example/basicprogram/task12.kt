package com.example.basicprogram

//sort arraylist string

fun main(){
    val a= mutableListOf("abc","cab","bab","cba","bca","aba","aac")
    a.sort()
    print("Sorting : $a")
}


//  Sorting : [aac, aba, abc, bab, bca, cab, cba]