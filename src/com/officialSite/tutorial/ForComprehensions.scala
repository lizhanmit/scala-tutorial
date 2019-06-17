package com.officialSite.tutorial

object ForComprehensions {

    def main(args: Array[String]): Unit = {
        
        case class User(name: String, age: Int)
        val userBase = List(
            User("Travis", 28),
            User("Kelly", 33),
            User("Jennifer", 44),
            User("Dennis", 23))

        // here, yield will return a list
        val someUsers = for (user <- userBase if (user.age >= 20 && user.age < 30)) yield user.name
        someUsers.foreach(println)
        

        def foo(n: Int, v: Int) = {
            for (i <- 0 until n; j <- 0 until n if i + j == v) yield (i, j)
        }
        
        foo(10, 10).foreach({
            case (i, j) => println(s"($i, $j)")
        })
    }
}