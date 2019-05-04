package com.officialSite.tutorial

/**
 * A method can have an implicit parameter list, 
 * marked by the implicit keyword at the start of the parameter list.
 *  
 * If the parameters in that parameter list are not passed as usual, 
 * Scala will look if it can get an implicit value of the correct type, 
 * and if it can, pass it automatically.
 */
abstract class Monoid[A] {
    def add(x: A, y: A): A
    def unit: A
}

object ImplicitParameters {

  implicit val stringMonoid: Monoid[String] = new Monoid[String] {
      def add(x: String, y: String): String = x concat y
      def unit: String = ""
  }
  
  implicit val intMonoid: Monoid[Int] = new Monoid[Int] {
      def add(x: Int, y: Int): Int = x + y
      def unit: Int = 0
  }
  
  def sum[A](xs: List[A])(implicit m: Monoid[A]): A = {
      if (xs.isEmpty) {
          m.unit
      } else {
        m.add(xs.head, sum(xs.tail))
      }
  }
  
  def main(args: Array[String]): Unit = {
    println(sum(List(1, 2, 3)))
    println(sum(List("a", "b", "c")))
  }
  
}