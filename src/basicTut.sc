import java.io.PrintWriter
import scala.io.Source

object basicTut {
  val l = List("aaaa", "b", "c")                  //> l  : List[String] = List(aaaa, b, c)
 
  /*
   * for block
   */
  for {
  	i <- l // generator, for each element in the list
  } println (i)                                   //> aaaa
                                                  //| b
                                                  //| c
  
  for {
  	i <- l
		if (i.length > 3) // filter
  } println (i)                                   //> aaaa
  
  
  val result_for = for {
  	i <- l
  	i1 = i.toUpperCase() // variable binding
  	if (i1 != "")
  } yield (i1) // generate a new collection       //> result_for  : List[String] = List(AAAA, B, C)
  
  result_for                                      //> res0: List[String] = List(AAAA, B, C)
  
  
  
  // until is often used to loop through strings or arrays
	val randLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                                  //> randLetters  : String = ABCDEFGHIJKLMNOPQRSTUVWXYZ
	for (i <- 0 until randLetters.length){
		// Get the letter in the index of the String
		println(randLetters(i))           //> A
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
  	val primeList = List(1,2,3,5,7,11)
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
   */
  val code = 1                                    //> code  : Int = 1
  val result_match = code match {
  	case 1 => "one"
  	case 2 => "two"
  	case _ => "others"
  }                                               //> result_match  : String = one
  

	/*
	 * string
	 */
	 var s = "hello "                         //> s  : String = "hello "
	 s(1)                                     //> res1: Char = e
	 s.concat("world")                        //> res2: String = hello world
	 s.toArray                                //> res3: Array[Char] = Array(h, e, l, l, o,  )
	 s.indexOf("o")                           //> res4: Int = 4


	/*
	 * IO
	 * import java.io.PrintWriter
	 * import scala.io.Source
	 */
	var writer = new PrintWriter("testIO.txt")//> writer  : java.io.PrintWriter = java.io.PrintWriter@337d0578
	writer.write("test1\ntest2")
	writer.close()
	
	var textFromFile = Source.fromFile("testIO.txt")
                                                  //> textFromFile  : scala.io.BufferedSource = non-empty iterator
	var lineIterator = textFromFile.getLines  //> lineIterator  : Iterator[String] = non-empty iterator
	for (line <- lineIterator)
		println(line)                     //> test1
                                                  //| test2
	textFromFile.close()
		

}