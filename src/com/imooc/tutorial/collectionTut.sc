object collectionTut {

  /*
   * Range
   */
	1 to 10                                   //> res0: scala.collection.immutable.Range.Inclusive = Range 1 to 10
	1 to 10 by 2                              //> res1: scala.collection.immutable.Range = inexact Range 1 to 10 by 2
	(1 to 10).toList                          //> res2: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
	1 until 10                                //> res3: scala.collection.immutable.Range = Range 1 until 10


  /*
   * Array
   */
  val intArr = new Array[Int](3)                  //> intArr  : Array[Int] = Array(0, 0, 0)
  intArr(0) = 1
  intArr(1) = 2
  intArr(2) = 3
  // or
  // val intArr = Array(1,2,3)
  for (i <- 0 to 2) println(intArr(i))            //> 1
                                                  //| 2
                                                  //| 3
  
  // Scala can deduce the type of the array implicitly
  var favNums = Array(1, 2, 3)                    //> favNums  : Array[Int] = Array(1, 2, 3)
  favNums.foreach(println)                        //> 1
                                                  //| 2
                                                  //| 3
  favNums.sum                                     //> res4: Int = 6
  favNums.min                                     //> res5: Int = 1
  favNums.max                                     //> res6: Int = 3

  // descending sort
  favNums.sortWith(_ > _)                         //> res7: Array[Int] = Array(3, 2, 1)
  // ascending sort
  favNums.sortWith(_ < _)                         //> res8: Array[Int] = Array(1, 2, 3)
  // change to String separated by commas
  favNums.deep.mkString(", ")                     //> res9: String = 1, 2, 3

	// two-dimensional array
	val myMatrix = Array.ofDim[Int](3, 4)  // 3 rows 4 columns
                                                  //> myMatrix  : Array[Array[Int]] = Array(Array(0, 0, 0, 0), Array(0, 0, 0, 0), 
                                                  //| Array(0, 0, 0, 0))
	
  /*
   * ArrayBuffer
   */
	import scala.collection.mutable.ArrayBuffer
	val myMutableArr = ArrayBuffer(1,2,3)     //> myMutableArr  : scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 2
                                                  //| , 3)
	// append 4 at the end
	myMutableArr += 4                         //> res10: collectionTut.myMutableArr.type = ArrayBuffer(1, 2, 3, 4)
	// insert 20 and 21 at index 2
	myMutableArr.insert(2, 20, 21)
	println(myMutableArr)                     //> ArrayBuffer(1, 2, 20, 21, 3, 4)
	// remove the first 3
	myMutableArr -= 3                         //> res11: collectionTut.myMutableArr.type = ArrayBuffer(1, 2, 20, 21, 4)
	// remove the element of index 1
	myMutableArr.remove(1)                    //> res12: Int = 2
	println(myMutableArr)                     //> ArrayBuffer(1, 20, 21, 4)
	
	
	
	/*
	 * Tuple
	 */
  var tuple1 = (103, "a", 10.5)                   //> tuple1  : (Int, String, Double) = (103,a,10.5)
  printf("%s owes us %.2f dollars\n", tuple1._2, tuple1._3)
                                                  //> a owes us 10.50 dollars
  tuple1.productIterator.foreach { println }      //> 103
                                                  //| a
                                                  //| 10.5
  tuple1.toString()                               //> res13: String = (103,a,10.5)
  
  // t is (0, 0d, 0d)
  // v is the input param
  // t._1 + 1: 0 + 1, three times, result is 3
  // t._2 + v: 0d + 1.0 + 2.0 + 3.0, result is 6.0
  // t._3 + v * v: 0d + 1.0 * 1.0 + 2.0 * 2.0 + 3.0 * 3.0, result is 14.0
  def sumSq(inputParam: List[Double]): (Int, Double, Double) =
  		inputParam.foldLeft((0, 0d, 0d))((t, v) => (t._1 + 1, t._2 + v, t._3 + v * v))
                                                  //> sumSq: (inputParam: List[Double])(Int, Double, Double)
  		
  	sumSq(List(1.0, 2.0, 3.0))                //> res14: (Int, Double, Double) = (3,6.0,14.0)
	
  /*
   * List
   */
  var a = List(1, 2, 3)                           //> a  : List[Int] = List(1, 2, 3)
  // another way to form a list
  1::2::3::Nil                                    //> res15: List[Int] = List(1, 2, 3)
  // ::, add an element at the beginning of a list
  a = 0 :: a
  println(a)                                      //> List(0, 1, 2, 3)
  
  var b = List(5, 6)                              //> b  : List[Int] = List(5, 6)
  // :::, connect two lists
  b = b ::: a
  // or
  b = b ++ a
	println(b)                                //> List(5, 6, 0, 1, 2, 3, 0, 1, 2, 3)
	
	
  // list.head, get the first element in the list
  // list.tail, get remaining elements in the list after the first one
  def walkthru(l: List[Int]): String = {
    if (l.isEmpty) ""
    else l.head.toString + " " + walkthru(l.tail)
  }                                               //> walkthru: (l: List[Int])String

  walkthru(b)                                     //> res16: String = "5 6 0 1 2 3 0 1 2 3 "

  // get odd numbers in the list
  a.filter(x => x % 2 == 1)                       //> res17: List[Int] = List(1, 3)

  // get digital numbers in the string
  "99 Red Balloons".toList.filter(x => Character.isDigit(x))
                                                  //> res18: List[Char] = List(9, 9)
  // get elements until the element is 'B'
  "99 Red Balloons".toList.takeWhile(x => x != 'B')
                                                  //> res19: List[Char] = List(9, 9,  , R, e, d,  )

  var c = List("x", "y", "z")                     //> c  : List[String] = List(x, y, z)
  c.map(x => x.toUpperCase)                       //> res20: List[String] = List(X, Y, Z)
  c.map(_.toUpperCase) // short version           //> res21: List[String] = List(X, Y, Z)

  a.filter(_ % 2 == 1).map(_ + 10)                //> res22: List[Int] = List(11, 13)

  var q = List(a, b)                              //> q  : List[List[Int]] = List(List(0, 1, 2, 3), List(5, 6, 0, 1, 2, 3, 0, 1, 
                                                  //| 2, 3))
  q.map(_.filter(_ % 2 == 1))                     //> res23: List[List[Int]] = List(List(1, 3), List(5, 1, 3, 1, 3))
  // flatMap is used to merge two lists in the result
  q.flatMap(_.filter(_ % 2 == 1))                 //> res24: List[Int] = List(1, 3, 5, 1, 3, 1, 3)

  a.reduceLeft(_ + _)                             //> res25: Int = 6
  // with start value: 0
  a.foldLeft(0)(_ + _)                            //> res26: Int = 6
  // with start value: 1
  a.foldLeft(1)(_ * _)                            //> res27: Int = 0

  /*
	 * Map
	 */
  var m = Map(1 -> "a", 2 -> "b")                 //> m  : scala.collection.immutable.Map[Int,String] = Map(1 -> a, 2 -> b)
  m(1)                                            //> res28: String = a
  m.contains(2)                                   //> res29: Boolean = true
  m.keys                                          //> res30: Iterable[Int] = Set(1, 2)
  m.values                                        //> res31: Iterable[String] = MapLike.DefaultValuesIterable(a, b)
  // +, add a key-value pair in the Map
  m + (3 -> "c")                                  //> res32: scala.collection.immutable.Map[Int,String] = Map(1 -> a, 2 -> b, 3 -
                                                  //| > c)
  // remove a specific key-value pair from the Map by key
  m - (1)                                         //> res33: scala.collection.immutable.Map[Int,String] = Map(2 -> b)
  // add more than one key-value pairs in the Map
  m ++ List(3 -> "c", 4 -> "d")                   //> res34: scala.collection.immutable.Map[Int,String] = Map(1 -> a, 2 -> b, 3 -
                                                  //| > c, 4 -> d)
  // remove more than one key-value pairs from the Map by keys
  m -- List(1, 2)                                 //> res35: scala.collection.immutable.Map[Int,String] = Map()

  // mutable Map
  var customers = collection.mutable.Map(100 -> "a", 101 -> "b")
                                                  //> customers  : scala.collection.mutable.Map[Int,String] = Map(101 -> b, 100 -
                                                  //| > a)
  printf("Cust 1: %s\n", customers(100))          //> Cust 1: a
  customers(100) = "A"
  customers(101) = "b"
  for ((k, v) <- customers) printf("%d: %s\n", k, v)
                                                  //> 101: b
                                                  //| 100: A


  /*
	 * Stream
	 * Stream is a lazy List that only the first element is computed.
	 */
	val str = 1 #:: 2 #:: 3 #:: Stream.empty  //> str  : scala.collection.immutable.Stream[Int] = Stream(1, ?)
	val stream = (1 to 10000000).toStream     //> stream  : scala.collection.immutable.Stream[Int] = Stream(1, ?)
	stream.head                               //> res36: Int = 1
	stream.tail                               //> res37: scala.collection.immutable.Stream[Int] = Stream(2, ?)

  /*
	 * Quicksort
	 */
  def quickSort(a: List[Int]): List[Int] =
    if (a.length < 2) a
    else quickSort(a.filter(_ < a.head)) ++ a.filter(_ == a.head) ++ quickSort(a.filter(_ > a.head))
                                                  //> quickSort: (a: List[Int])List[Int]

  quickSort(List(3, 2, 5, 1, 9, 8, 6, 7, 0, 4))   //> res38: List[Int] = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

}