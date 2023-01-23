package com.example.basicprogram

import java.util.*

internal class Employee {
    private var id = 0
    private var name: String? = null

    constructor() {}
    constructor(id: Int, name: String?) : super() {
        this.id = id
        this.name = name
    }

    override fun toString(): String {
        return "Employee [employeeId=$id, employeeName=$name]"
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + if (name == null) 0 else name.hashCode()
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        if (javaClass != obj.javaClass) return false
        val other = obj as Employee
        if (name == null) {
            if (other.name != null) return false
        } else if (name != other.name) return false
        return true
    }
}

object ArrayListDemo {
    @JvmStatic
    fun main(args: Array<String>) {
        val employees: MutableList<Employee> = ArrayList()
        employees.add(Employee(1, "Sachin"))
        employees.add(Employee(2, "Stevan"))
        employees.add(Employee(3, "Kenneth"))
        employees.add(Employee(4, "Brian"))
        val employee = Employee(3, "Kenneth")
        // finds the index of Kenneth
        println("Index of Kenneth is: " + employees.indexOf(employee))
    }
}

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

/*
class Car     // Car constructor
    (// attributes
    var Modelno: Int, var name: String, var city: String,
    var stock: Int
) : Comparable<Car?> {
    // Override the compareTo() method
    override operator fun compareTo(c: Car): Int {
        return name.compareTo(c.name)
    }
}



    fun main(args: Array<String>) {

        // Define an objects of TreeSet class
        val set = TreeSet<Car>()

        // Creating Car objects
        val c1 = Car(132, "BMW", "Rajkot", 35)
        val c2 = Car(269, "Audi", "Surat", 20)
        val c3 = Car(560, "Kia", "Vadodara", 15)
        val c4 = Car(109, "Creta", "Ahmedabad", 26)

        // Adding Car objects to TreeSet
        set.add(c1)
        set.add(c2)
        set.add(c3)
        set.add(c4)

        // Traversing TreeSet
        for (c: Car in set) {
            println(
                c.name + " " + c.stock + " "
                        + c.city + " " + c.Modelno
            )
        }
    }
*/




