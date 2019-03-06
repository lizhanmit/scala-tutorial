import java.io.PrintWriter
import scala.io.Source

object basicTut {
  val l = List("aaaa", "b", "c")                  //> l  : List[String] = List(aaaa, b, c)

  /*
   * for block
   */
  for {
    i <- l // generator, for each element in the list
  } println(i)                                    //> aaaa
                                                  //| b
                                                  //| c

  for {
    i <- l
    if (i.length > 3) // filter
  } println(i)                                    //> aaaa

  val result_for = for {
    i <- l
    i1 = i.toUpperCase() // variable binding
    if (i1 != "")
  } yield (i1) // generate a new collection       //> result_for  : List[String] = List(AAAA, B, C)

  result_for                                      //> res0: List[String] = List(AAAA, B, C)


  /*
   * yield
   * used to return a Vector in the for loop
   */
	val f = for (i <- 1 to 5) yield (i + 1)   //> f  : scala.collection.immutable.IndexedSeq[Int] = Vector(2, 3, 4, 5, 6)
	f.foreach(println)                        //> 2
                                                  //| 3
                                                  //| 4
                                                  //| 5
                                                  //| 6

  // until is often used to loop through strings or arrays
  val randLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"  //> randLetters  : String = ABCDEFGHIJKLMNOPQRSTUVWXYZ
  for (i <- 0 until randLetters.length) {
    // Get the letter in the index of the String
    println(randLetters(i))                       //> A
                                                  //| B
                                                  //| C
                                                  //| D
                                                  //| E
                                                  //| F
                                                  //| G
                                                  //| H
                                                  //| I
                                                  //| J
                                                  //| K
                                                  //| L
                                                  //| M
                                                  //| N
                                                  //| O
                                                  //| P
                                                  //| Q
                                                  //| R
                                                  //| S
                                                  //| T
                                                  //| U
                                                  //| V
                                                  //| W
                                                  //| X
                                                  //| Y
                                                  //| Z
  }

  /*
   * there is no break and continue in Scala loop
   */
  def printPrimes() {
    val primeList = List(1, 2, 3, 5, 7, 11)
    for (i <- primeList) {
      if (i == 7)
        return
      println(i)
    }
  }                                               //> printPrimes: ()Unit

  printPrimes                                     //> 1
                                                  //| 2
                                                  //| 3
                                                  //| 5

  /*
   * try catch finally
   */
  val result_try = try {
    Integer.parseInt("Dog")
  } catch {
    case _ => 0
  } finally {
    println("This is finally.")
  }                                               //> This is finally.
                                                  //| result_try  : Int = 0

  /*
   * match block
   * pattern matching
   */
  val code = 1                                    //> code  : Int = 1
  val result_match = code match {
    case 1 => "one"
    case 2 => "two"
    case _ => "others"
  }                                               //> result_match  : String = one

  /*
	 * String
	 */
  var s = "hello "                                //> s  : String = "hello "
  s(1)                                            //> res1: Char = e
  s.concat("world")                               //> res2: String = hello world
  s.toArray                                       //> res3: Array[Char] = Array(h, e, l, l, o,  )
  s.indexOf("o")                                  //> res4: Int = 4


  /*
	 * Iterator
	 */
	val iter = Iterator("a", "b", "c")        //> iter  : Iterator[String] = non-empty iterator
	while (iter.hasNext) println(iter.next)   //> a
                                                  //| b
                                                  //| c
	// or
	// as long as the Iterator has been accessed, it will be empty
	// so here is nothing to be printed out
	for (elem <- iter) println(elem)
	
	val myList = List(1,2,3,4,5)              //> myList  : List[Int] = List(1, 2, 3, 4, 5)
	// fixed-sized sequence “chunks”.
	val myGroup = myList grouped 3            //> myGroup  : Iterator[List[Int]] = non-empty iterator
	myGroup.next                              //> res5: List[Int] = List(1, 2, 3)
	myGroup.next                              //> res6: List[Int] = List(4, 5)
	// sliding fixed-sized window
	val mySliding = myList sliding 3          //> mySliding  : Iterator[List[Int]] = non-empty iterator
	mySliding.next                            //> res7: List[Int] = List(1, 2, 3)
	mySliding.next                            //> res8: List[Int] = List(2, 3, 4)
	mySliding.next                            //> res9: List[Int] = List(3, 4, 5)
	
	
	
  /*
	 * IO
	 * import java.io.PrintWriter
	 * import scala.io.Source
	 */
  var writer = new PrintWriter("testIO.txt")      //> writer  : java.io.PrintWriter = java.io.PrintWriter@6d00a15d
  writer.write("test1\ntest2")
  writer.close()

  var textFromFile = Source.fromFile("testIO.txt")//> textFromFile  : scala.io.BufferedSource = non-empty iterator
  var lineIterator = textFromFile.getLines        //> lineIterator  : Iterator[String] = non-empty iterator
  for (line <- lineIterator)
    println(line)                                 //> test1
                                                  //| test2
  textFromFile.close()

}