object LearningScala4 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(283); 
  // Data structures

  // Tuples (Also really common with Spark!!)
  // Immutable lists
  // Often thought of as database fields, or columns.
  // Useful for passing around entire rows of data.

  val captainStuff = ("Picard", "Enterprise-D", "NCC-1701-D");System.out.println("""captainStuff  : (String, String, String) = """ + $show(captainStuff ));$skip(24); 
  println(captainStuff);$skip(93); 

  // You refer to individual fields with their ONE-BASED index:
  println(captainStuff._1);$skip(27); 
  println(captainStuff._2);$skip(27); 
  println(captainStuff._3);$skip(94); 

  // You can create a key/value pair with ->
  val picardsShip = "Picard" -> "Enterprise-D";System.out.println("""picardsShip  : (String, String) = """ + $show(picardsShip ));$skip(26); 
  println(picardsShip._2);$skip(89); 

  // You can mix different types in a tuple
  val aBunchOfStuff = ("Kirk", 1964, true);System.out.println("""aBunchOfStuff  : (String, Int, Boolean) = """ + $show(aBunchOfStuff ));$skip(224); 

  // Lists
  // Like a tuple, but it's an actual Collection object that has more functionality.
  // It's a singly-linked list under the hood.

  val shipList = List("Enterprise", "Defiant", "Voyager", "Deep Space Nine");System.out.println("""shipList  : List[String] = """ + $show(shipList ));$skip(103); 

  // Access individual members using () with ZERO-BASED index (confused yet?)
  println(shipList(1));$skip(95); 

  // head and tail give you the first item, and the remaining ones.
  println(shipList.head);$skip(25); 
  println(shipList.tail);$skip(74); 

  // Iterating though a list
  for (ship <- shipList) { println(ship) };$skip(166); 

  // Let's apply a function literal to a list! map() can be used to apply any function to every item in a collection.
  val backwardShips = shipList.map(_.reverse);System.out.println("""backwardShips  : List[String] = """ + $show(backwardShips ));$skip(48); 
  for (ship <- backwardShips) { println(ship) };$skip(138); 

  // reduce() can be used to combine together all the items in a collection using some function.
  val numberList = List(1, 2, 3, 4, 5);System.out.println("""numberList  : List[Int] = """ + $show(numberList ));$skip(57); 
  val sum = numberList.reduce((x: Int, y: Int) => x + y);System.out.println("""sum  : Int = """ + $show(sum ));$skip(62); 
  // or
  //val sum = numberList.reduce(_ + _)
  println(sum);$skip(162); 

  // filter() can remove stuff you don't want. Here we'll introduce wildcard syntax while we're at it.
  val iHateFives = numberList.filter((x: Int) => x != 5);System.out.println("""iHateFives  : List[Int] = """ + $show(iHateFives ));$skip(46); 
  val iHateThrees = numberList.filter(_ != 3);System.out.println("""iHateThrees  : List[Int] = """ + $show(iHateThrees ));$skip(239); 

  // Note that Spark has its own map, reduce, and filter functions that can distribute these operations. But they work the same way!
  // Also, you understand MapReduce now :)

  // Concatenating lists
  val moreNumbers = List(6, 7, 8);System.out.println("""moreNumbers  : List[Int] = """ + $show(moreNumbers ));$skip(48); 
  val lotsOfNumbers = numberList ++ moreNumbers;System.out.println("""lotsOfNumbers  : List[Int] = """ + $show(lotsOfNumbers ));$skip(57); 

  // More list fun
  val reversed = numberList.reverse;System.out.println("""reversed  : List[Int] = """ + $show(reversed ));$skip(31); 
  val sorted = reversed.sorted;System.out.println("""sorted  : List[Int] = """ + $show(sorted ));$skip(50); 
  val lotsOfDuplicates = numberList ++ numberList;System.out.println("""lotsOfDuplicates  : List[Int] = """ + $show(lotsOfDuplicates ));$skip(36); val res$0 = 
  // or
  numberList ::: numberList;System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(49); 
  val distinctValues = lotsOfDuplicates.distinct;System.out.println("""distinctValues  : List[Int] = """ + $show(distinctValues ));$skip(32); 
  val maxValue = numberList.max;System.out.println("""maxValue  : Int = """ + $show(maxValue ));$skip(29); 
  val total = numberList.sum;System.out.println("""total  : Int = """ + $show(total ));$skip(41); 
  val hasThree = iHateThrees.contains(3);System.out.println("""hasThree  : Boolean = """ + $show(hasThree ));$skip(233); 

  // Maps
  // Useful for key/value lookups on distinct keys
  // Like dictionaries in other languages

  val shipMap = Map("Kirk" -> "Enterprise", "Picard" -> "Enterprise-D", "Sisko" -> "Deep Space Nine", "Janeway" -> "Voyager");System.out.println("""shipMap  : scala.collection.immutable.Map[String,String] = """ + $show(shipMap ));$skip(30); 
  println(shipMap("Janeway"));$skip(71); 

  // Dealing with missing keys
  println(shipMap.contains("Archer"));$skip(70); 

  val archersShip = util.Try(shipMap("Archer")) getOrElse "Unknown";System.out.println("""archersShip  : String = """ + $show(archersShip ));$skip(23); 
  println(archersShip);$skip(491); 

  // EXERCISE
  // Create a list of the numbers 1-20; your job is to print out numbers that are evenly divisible by three. (Scala's
  // modula operator, like other languages, is %, which gives you the remainder after division. For example, 9 % 3 = 0
  // because 9 is evenly divisible by 3.) Do this first by iterating through all the items in the list and testing each
  // one as you go. Then, do it again by using a filter function on the list instead.
	val numList = (1 to 20).toList;System.out.println("""numList  : List[Int] = """ + $show(numList ));$skip(51); 
	for (i <- numList) {
		if (i % 3 == 0) println(i)
	};$skip(47); 
	// or
	println(numList.filter(_ % 3 == 0))}

}
