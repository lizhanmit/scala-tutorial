package com.officialSite.tutorial

/**
 * P <: Pet
 * Pet is the upper type bound of P
 * 
 * P >: Pet
 * Pet is the lower type bound of P
 */
object UpperTypeBounds extends App {
  
    abstract class Animal {
        def name: String
    }
    
    abstract class Pet extends Animal 
    
    class Cat extends Pet {
        override def name: String = "cat"
    }
    
    class Dog extends Pet {
        override def name: String = "dog"
    }
    
    class Lion extends Animal {
        override def name: String = "lion"
    }
    
    class PetContainer[P <: Pet](p: P) {
        def pet: P = p
    }
    
    val catContainer = new PetContainer[Cat](new Cat)
    val dogContainer = new PetContainer[Dog](new Dog)
    // compile error because class Lion is not subtype of class Pet
    //val lionContainer = new PetContainer[Lion](new Lion)
}