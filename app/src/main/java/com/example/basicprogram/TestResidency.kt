package com.example.basicprogram

import kotlin.collections.ArrayList


abstract class Residency(var area:Int,var rate_peryard:Int){
    abstract fun calculatePropertyPrice():Int
}


class Flat(area: Int,rate_peryard: Int) : Residency(area, rate_peryard){

    override fun calculatePropertyPrice(): Int {
        return area * rate_peryard
    }
}

class Villa(area: Int,rate_peryard: Int) : Residency(area, rate_peryard) {

    override fun calculatePropertyPrice():Int {
        return area * rate_peryard
    }
}



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






















