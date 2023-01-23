package com.example.basicprogram

import android.os.Build
import androidx.annotation.RequiresApi
import java.io.File
import java.time.LocalDate
import java.util.TreeSet


class Order(var orderDate: LocalDate, var productName: String, var quantity: Int) :
    Comparable<Order> {
    override fun compareTo(other: Order): Int {
        return quantity.compareTo(other.quantity)
    }
}

class OrderManagement {

    val ts = TreeSet<Order>()

    @RequiresApi(Build.VERSION_CODES.O)
    fun placeOrder() {

        val data = Order(LocalDate.of(2022, 12, 29), "abc", 5)
        val data1 = Order(LocalDate.of(2022, 3, 24), "aa", 7)
        val data2 = Order(LocalDate.of(2022, 5, 2), "vv", 2)
        val data3 = Order(LocalDate.of(2022, 9, 15), "cc", 10)
        val data4 = Order(LocalDate.of(2022, 4, 13), "ll", 50)
        val data5 = Order(LocalDate.of(2022, 4, 13), "ll", 50)


        ts.add(data)
        ts.add(data1)
        ts.add(data2)
        ts.add(data3)
        ts.add(data4)
        ts.add(data5)

        for (a: Order in ts) {
            println("Order is: ${a.orderDate} ${a.productName} ${a.quantity}")
        }
    }

    fun displayOrdersByDate() {
        println()
        val dates = ts.sortedBy { it.orderDate }
        for (i: Order in dates) {
            println("Sorted by Dates:  ${i.orderDate} ${i.productName} ${i.quantity}")
        }
    }

    fun displayOrdersByName() {
        println()
        val names = ts.sortedBy { it.productName }
        for (i: Order in names) {
            println("Sorted by Product Name:  ${i.orderDate} ${i.productName} ${i.quantity}")
        }
    }

    fun storeOrder(){
        println()
        val text = File("ordersinfo.txt").readText()
        println(text)
    }
}


@RequiresApi(Build.VERSION_CODES.O)
fun main() {
    val orderManagement = OrderManagement()
    orderManagement.placeOrder()
    orderManagement.displayOrdersByDate()
    orderManagement.displayOrdersByName()
    orderManagement.storeOrder()

}
