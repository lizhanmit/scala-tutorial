import java.io.PrintWriter
import scala.io.Source

object basicTut {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(102); 
  val l = List("aaaa", "b", "c");System.out.println("""l  : List[String] = """ + $show(l ));$skip(105); 

  /*
   * for block
   */
  for {
    i <- l // generator, for each element in the list
  } println(i);$skip(68); 

  for {
    i <- l
    if (i.length > 3) // filter
  } println(i);$skip(145); 

  val result_for = for {
    i <- l
    i1 = i.toUpperCase() // variable binding
    if (i1 != "")
  } yield (i1);System.out.println("""result_for  : List[String] = """ + $show(result_for ));$skip(15); val res$0 =  // generate a new collection

  result_for;System.out.println("""res0: List[String] = """ + $show(res$0));$skip(112); 


  /*
   * yield
   * used to return a Vector in the for loop
   */
	val f = for (i <- 1 to 5) yield (i + 1);System.out.println("""f  : scala.collection.immutable.IndexedSeq[Int] = """ + $show(f ));$skip(20); 
	f.foreach(println);$skip(110); 

  // until is often used to loop through strings or arrays
  val randLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";System.out.println("""randLetters  : String = """ + $show(randLetters ));$skip(119); 
  for (i <- 0 until randLetters.length) {
    // Get the letter in the index of the String
    println(randLetters(i))
  };$skip(220); 

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
  };System.out.println("""printPrimes: ()Unit""");$skip(16); 

  printPrimes;$skip(167); 

  /*
   * try catch finally
   */
  val result_try = try {
    Integer.parseInt("Dog")
  } catch {
    case _ => 0
  } finally {
    println("This is finally.")
  };System.out.println("""result_try  : Int = """ + $show(result_try ));$skip(67); 

  /*
   * match block
   * pattern matching
   */
  val code = 1;System.out.println("""code  : Int = """ + $show(code ));$skip(101); 
  val result_match = code match {
    case 1 => "one"
    case 2 => "two"
    case _ => "others"
  };System.out.println("""result_match  : String = """ + $show(result_match ));$skip(121); 

val planets =
  List(("Mercury", 57.9), ("Venus", 108.2), ("Earth", 149.6),
       ("Mars", 227.9), ("Jupiter", 778.3));System.out.println("""planets  : List[(String, Double)] = """ + $show(planets ));$skip(133); 
planets.foreach{
  case ("Earth", distance) =>
    println(s"Our planet is $distance million kilometers from the sun")
  case _ =>
};$skip(43); 


  /*
	 * String
	 */
  var s = "hello ";System.out.println("""s  : String = """ + $show(s ));$skip(7); val res$1 = 
  s(1);System.out.println("""res1: Char = """ + $show(res$1));$skip(20); val res$2 = 
  s.concat("world");System.out.println("""res2: String = """ + $show(res$2));$skip(12); val res$3 = 
  s.toArray;System.out.println("""res3: Array[Char] = """ + $show(res$3));$skip(17); val res$4 = 
  s.indexOf("o");System.out.println("""res4: Int = """ + $show(res$4));$skip(63); 


  /*
	 * Iterator
	 */
	val iter = Iterator("a", "b", "c");System.out.println("""iter  : Iterator[String] = """ + $show(iter ));$skip(41); 
	while (iter.hasNext) println(iter.next);$skip(146); 
	// or
	// as long as the Iterator has been accessed, it will be empty
	// so here is nothing to be printed out
	for (elem <- iter) println(elem);$skip(33); 
	
	val myList = List(1,2,3,4,5);System.out.println("""myList  : List[Int] = """ + $show(myList ));$skip(67); 
	// fixed-sized sequence “chunks”.
	val myGroup = myList grouped 3;System.out.println("""myGroup  : Iterator[List[Int]] = """ + $show(myGroup ));$skip(14); val res$5 = 
	myGroup.next;System.out.println("""res5: List[Int] = """ + $show(res$5));$skip(14); val res$6 = 
	myGroup.next;System.out.println("""res6: List[Int] = """ + $show(res$6));$skip(65); 
	// sliding fixed-sized window
	val mySliding = myList sliding 3;System.out.println("""mySliding  : Iterator[List[Int]] = """ + $show(mySliding ));$skip(16); val res$7 = 
	mySliding.next;System.out.println("""res7: List[Int] = """ + $show(res$7));$skip(16); val res$8 = 
	mySliding.next;System.out.println("""res8: List[Int] = """ + $show(res$8));$skip(16); val res$9 = 
	mySliding.next;System.out.println("""res9: List[Int] = """ + $show(res$9));$skip(129); 
	
	
	
  /*
	 * IO
	 * import java.io.PrintWriter
	 * import scala.io.Source
	 */
  var writer = new PrintWriter("testIO.txt");System.out.println("""writer  : java.io.PrintWriter = """ + $show(writer ));$skip(31); 
  writer.write("test1\ntest2");$skip(17); 
  writer.close();$skip(53); 

  var textFromFile = Source.fromFile("testIO.txt");System.out.println("""textFromFile  : scala.io.BufferedSource = """ + $show(textFromFile ));$skip(43); 
  var lineIterator = textFromFile.getLines;System.out.println("""lineIterator  : Iterator[String] = """ + $show(lineIterator ));$skip(47); 
  for (line <- lineIterator)
    println(line);$skip(23); 
  textFromFile.close()}

}
