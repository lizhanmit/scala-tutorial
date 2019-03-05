package com.officialSite.tutorial.classes

object ComplexNumbers2 {
  def main(args: Array[String]): Unit = {
    val c = new Complex2(1.2, 3.4)
    println("imaginary part: " + c.im)  // omit () after im() method
    println(c)
  }
}