package com.officialSite.tutorial.traits

object TraitsDemo {
  def main(args: Array[String]): Unit = {
    val d1 = new Date(2019, 3, 6)
    val d2 = new Date(2019, 3, 6)
    val d3 = new Date(2019, 3, 5)
    val d4 = "2019-3-6"
    
    println(d1.<(d2))  // false
    println(d1.equals(d2))  // true
    println(d3.<(d2))  // true
    println(d3.equals(d2))  // false
    println(d1.<(d4))  // error message
  }
}