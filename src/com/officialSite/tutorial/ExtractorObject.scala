package com.officialSite.tutorial

import scala.util.Random

/**
 * An extractor object is an object with an "unapply" method.
 * The "apply" method is like a constructor.
 * The "unapply" takes an object and tries to give back the arguments.
 */
object CustomerID {
    def apply(name: String): String = s"$name--${Random.nextLong}"
    
    def unapply(customerID: String): Option[String] = {
        val stringArray: Array[String] = customerID.split("--")
        if (stringArray.tail.nonEmpty) {
            Some(stringArray.head)  
        } else {
            None
        }
    }
}

object ExtractorObject {
    def main(args: Array[String]): Unit = {
		val customer1ID = CustomerID("Zhangsan")
		customer1ID match {
    		case CustomerID(name) => println(name)
    		case _ => println("Could not extract a CustomerID")
		}
      
		
		val customer2ID = CustomerID("Lisi")
		val CustomerID(name) = customer2ID
		println(name)
    }
}