package com.example.basicprogram

//Remove Duplicate Element in Array

fun main(){
    val data = arrayOf(1,6,0,4,8,1,5,0,6,9,3,4)
    //data.sort()

    //remove duplicate element
    val uniqueData = data.distinct()
    print("Remove Duplicate Data : $uniqueData")


}

//  [1,6,0,4,8,5,9,3]