package com.example.basicprogram

class Employee(var emp_code:Int,val emp_name:String,val basic_sal:Int,var gross_sal:Double)

fun main(){
    val arrayList:ArrayList<Employee> = arrayListOf<Employee>()

    val e1=Employee(101,"Jack",15433,15420.0)
    arrayList.add(e1)

    val e2=Employee(102,"John",20000,17000.0)
    arrayList.add(e2)


    val e3=Employee(103,"Jenny",33982,50000.0)
    arrayList.add(e3)

    for (i in arrayList){
        i.gross_sal=i.basic_sal+ (0.2*(i.basic_sal)) + (0.3*(i.basic_sal))
        println("${i.emp_code} ${i.emp_name} ${i.basic_sal} ${i.gross_sal}")
    }
}

