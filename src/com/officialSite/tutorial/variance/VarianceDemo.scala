package com.officialSite.tutorial.variance

/**
 * Covariance: <className>[+A]
 * if A is a subtype of B
 * <className>[A] is a subtype of <className>[B]
 *
 * Contravariance: <className>[-A]
 * if A is a subtype of B
 * <className>[B] is a subtype of <className>[A]
 * 
 * Invariance：
 * by default
 * if A is a subtype of B
 * there is no relationship between <className>[B] and <className>[A]
 */
object VarianceDemo extends App {
    /*
     * Covariance
     */
    println("=== Covariance ===")
    abstract class Animal {
        def name: String
    }
    case class Cat(name: String) extends Animal
    case class Dog(name: String) extends Animal

    /*
     * because there is "sealed abstract class List[+A]" in Scala standard library
   	 * as a result, when Cat and Dog are subtypes of Animal
   	 * List[Cat] and List[Dog] are subtype of List[Animal]
     * they are able to be printed out here
     */
    def printAnimalName(animals: List[Animal]) = {
        animals.foreach(x => println(x.name))
    }

    val cats: List[Cat] = List(Cat("Whiskers"), Cat("Tom"))
    val dogs: List[Dog] = List(Dog("Fido"), Dog("Rex"))

    printAnimalName(cats)
    printAnimalName(dogs)

    /*
     * Contravariance
     */
    println("=== Contravariance ===")
    abstract class Printer[-A] {
        def print(value: A): Unit
    }

    class AnimalPrinter extends Printer[Animal] {
        def print(animal: Animal): Unit = {
            println("The animal's name is: " + animal.name)
        }
    }
    
    class CatPrinter extends Printer[Cat] {
        def print(cat: Cat): Unit = {
            println("The cat's name is: " + cat.name)
        }
    }
    
    val myCat: Cat = new Cat("Boots")
    
    def printMyCat(printer: Printer[Cat]) = {
        printer.print(myCat)
    }
    
    val catPrinter: Printer[Cat] = new CatPrinter
    val animalPrinter: Printer[Animal] = new AnimalPrinter
    
    printMyCat(catPrinter)
    // if you did not define abstract class Printer[-A] before
    // you will get complie error because Cat is a subtype of Animal
    // once you define Printer[-A], Printer[Animal] is the subtype of Printer[Cat] 
    printMyCat(animalPrinter)

    
    
    /*
     * Invariance
     */
    println("=== Invariance ===")
    class Container[A](value: A) {
        private var _value: A = value
        def getValue: A = _value
        def setValue(value: A): Unit = {
            _value = value
        }
    }
    
    val catContainer: Container[Cat] = new Container(Cat("Felix"))
    // there is compile error for this line
    // Cat is a subtype of Animal, you defined Container[A] above not Container[+A]
    // so, here, Container[Cat] is not subtype of Container[Animal]
    //val animalContainer: Container[Animal] = catContainer
    
}