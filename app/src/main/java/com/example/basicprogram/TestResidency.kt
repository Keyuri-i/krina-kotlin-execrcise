package com.example.basicprogram


abstract class Residency(var area: Double, var rate_peryard: Double) {
    open fun calculatePropertyPrice(): Double {
        return area * rate_peryard
    }
}


class Flat(area: Double, rate_peryard: Double, var maintenanceCharge: Double) :
    Residency(area, rate_peryard) {

    override fun calculatePropertyPrice(): Double {
        return calculatePropertyPrice() + maintenanceCharge
    }
}

class Villa(area: Double, rate_peryard: Double, var furnitureCharge: Double) :
    Residency(area, rate_peryard) {

    override fun calculatePropertyPrice(): Double {
        return calculatePropertyPrice() + furnitureCharge
    }
}
class TestResidency {
    fun searchResidency(res: Residency, houses: Array<Residency>): Int {
        for (i in houses.indices) {
            if (houses[i] == res) {
                return i
            }
        }
        println("Residency not found")
        return -1
    }
}


fun totalMaintenancePrice(houses: Array<Residency>): Double {
    var total = 0.0
    for (house in houses) {
        if (house is Flat) {
            total += house.maintenanceCharge
        }
    }
    return total
}

fun displayOrderByPrice(houses: Array<Residency>) {
    houses.sortWith(Comparator { o1, o2 ->
        o1.calculatePropertyPrice().compareTo(o2.calculatePropertyPrice())
    })
    for (house in houses) {
        println(house.calculatePropertyPrice())
    }
}

fun main() {
    val testResidency: TestResidency
    //testResidency.searchResidency(100.0,)
}

/*

fun main(){
    val res= ArrayList<Residency>()


    res.add(Flat(10,10))
    res.add(Flat(120,12000))
    res.add(Villa(150,15000))
    res.add(Flat(10,10))
    res.add(Villa(130,13000))


    for (data in res){
        println("${data.calculatePropertyPrice()}")
    }

        val sortedList = res.sortedWith(compareBy({ it.calculatePropertyPrice() }))

    println("Display Order By their Price :")
        for (obj in sortedList) {

            println( obj.calculatePropertyPrice())
    }
}
*/