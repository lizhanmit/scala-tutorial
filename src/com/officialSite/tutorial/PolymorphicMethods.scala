package com.officialSite.tutorial

object PolymorphicMethods {
    
  def listOfDuplicates[A](x: A, length: Int): List[A] = {
      if (length < 1) {
          Nil
      } else {
    	  x :: listOfDuplicates(x, length - 1)
      }
  }
  
  def main(args: Array[String]): Unit = {
    println(listOfDuplicates[Int](3, 4))
    
    println(listOfDuplicates("hi", 4))  // type inference, not necessary specify [A] explicitly
  }
}