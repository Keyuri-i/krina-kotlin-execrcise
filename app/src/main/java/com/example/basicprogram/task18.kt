package com.example.basicprogram

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.util.*

class Account(val accountId: Int,val balance:Double,val accountType:Char,val creationDate:LocalDate):Comparable<Account>{
    @RequiresApi(Build.VERSION_CODES.O)
    override fun compareTo(other: Account): Int {
        val date=creationDate.compareTo(other.creationDate)
        val bal=balance.compareTo(other.balance)
        return date.compareTo(bal)
    }
}


abstract class Bank {

    var set: HashSet<Account> = HashSet()
    val array=set.toArray()

    abstract fun openAccount()

    abstract  fun closeAccount()

    abstract fun sort()

    abstract fun listAccOrderByBalance()

    abstract fun listOrderByDate()

}

class BankIntoTest: Bank() {

    lateinit var account : Account
    lateinit var account1 : Account
    lateinit var account2 : Account
   // lateinit var account3 : Account
    lateinit var account4 : Account
    lateinit var account5 : Account

    @RequiresApi(Build.VERSION_CODES.O)
    override fun openAccount() {

        account1 = Account(1,18752.0,'s', LocalDate.of(2010,3,24))
        set.add(account1)
        account2=Account(4,22600.0,'s', LocalDate.of(2020,9,13))
        set.add(account2)
      /*  account3=Account(2,20000.0,'c', LocalDate.of(2022,2,26))
        set.add(account3)*/
        account4=Account(2,20000.0,'c', LocalDate.of(2022,2,26))
        set.add(account4)
        account5=Account(3,15000.0,'s', LocalDate.of(2022,4,7 ))
        set.add(account5)
        account=Account(5,36000.0,'c', LocalDate.of(2018,5,15))
        set.add(account)

        for (data in set) {
            println("All Data: ${data.accountId} ${data.balance} ${data.accountType} ${data.creationDate}")
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun closeAccount() {
        println()
        set.remove(account1)
        for (accounts in set) {
            println("Remove Element: ${accounts.accountId} ${accounts.balance} ${accounts.accountType} ${accounts.creationDate}")
        }
    }

    override fun listAccOrderByBalance() {
        println()
        set.toArray(array)
        val sotring=set.sortedBy { it.balance}
        for (a in sotring){
            println("Sorted by balance : ${a.accountId} ${a.balance} ${a.accountType} ${a.creationDate}")
        }

    }

    override fun sort() {
        println()
        set.toArray(array)
        val sortedWith=set.sortedBy { it.creationDate }
        for (a in sortedWith){
            println("Sorted by Date compare : ${a.accountId} ${a.balance} ${a.accountType} ${a.creationDate}")
        }
    }

    override fun listOrderByDate() {
        println()
        set.toArray(array)
        val sotring=set.sortedBy { it.creationDate}
        for (a in sotring){
            println("Sorted by date: ${a.accountId} ${a.balance} ${a.accountType} ${a.creationDate}")
        }
    }
}
@RequiresApi(Build.VERSION_CODES.O)
fun main(){
    val infoTest = BankIntoTest()

    infoTest.openAccount()
    infoTest.closeAccount()
    infoTest.listAccOrderByBalance()
    infoTest.listOrderByDate()
    infoTest.sort()
}