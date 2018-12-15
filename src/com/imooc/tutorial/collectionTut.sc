object collectionTut {
  /*
   * Array
   */
  var favNums = Array(1, 2, 3)                    //> favNums  : Array[Int] = Array(1, 2, 3)
  favNums.foreach(println)                        //> 1
                                                  //| 2
                                                  //| 3
  favNums.sum                                     //> res0: Int = 6
  favNums.min                                     //> res1: Int = 1
  favNums.max                                     //> res2: Int = 3

  // descending sort
  favNums.sortWith(_ > _)                         //> res3: Array[Int] = Array(3, 2, 1)
  // ascending sort
  favNums.sortWith(_ < _)                         //> res4: Array[Int] = Array(1, 2, 3)
  // change to String separated by commas
  favNums.deep.mkString(", ")                     //> res5: String = 1, 2, 3

  /*
   * List
   */
  var a = List(1, 2, 3)                           //> a  : List[Int] = List(1, 2, 3)
  // ::, add an element at the beginning of a list
  a = 0 :: a
  println(a)                                      //> List(0, 1, 2, 3)
  
  var b = List(5, 6)                              //> b  : List[Int] = List(5, 6)
  // :::, connect two lists
  b = b ::: a
  // or
  //b = b ++ a
	println(b)                                //> List(5, 6, 0, 1, 2, 3)
	
	
  // list.head, get the first element in the list
  // list.tail, get remaining elements in the list after the first one
  def walkthru(l: List[Int]): String = {
    if (l.isEmpty) ""
    else l.head.toString + " " + walkthru(l.tail)
  }                                               //> walkthru: (l: List[Int])String

  walkthru(b)                                     //> res6: String = "5 6 0 1 2 3 "

  // get odd numbers in the list
  a.filter(x => x % 2 == 1)                       //> res7: List[Int] = List(1, 3)

  // get digital numbers in the string
  "99 Red Balloons".toList.filter(x => Character.isDigit(x))
                                                  //> res8: List[Char] = List(9, 9)
  // get elements until the element is 'B'
  "99 Red Balloons".toList.takeWhile(x => x != 'B')
                                                  //> res9: List[Char] = List(9, 9,  , R, e, d,  )

  var c = List("x", "y", "z")                     //> c  : List[String] = List(x, y, z)
  c.map(x => x.toUpperCase)                       //> res10: List[String] = List(X, Y, Z)
  c.map(_.toUpperCase) // short version           //> res11: List[String] = List(X, Y, Z)

  a.filter(_ % 2 == 1).map(_ + 10)                //> res12: List[Int] = List(11, 13)

  var q = List(a, b)                              //> q  : List[List[Int]] = List(List(0, 1, 2, 3), List(5, 6, 0, 1, 2, 3))
  q.map(_.filter(_ % 2 == 1))                     //> res13: List[List[Int]] = List(List(1, 3), List(5, 1, 3))
  // flatMap is used to merge two lists in the result
  q.flatMap(_.filter(_ % 2 == 1))                 //> res14: List[Int] = List(1, 3, 5, 1, 3)

  a.reduceLeft(_ + _)                             //> res15: Int = 6
  a.foldLeft(0)(_ + _)                            //> res16: Int = 6
  a.foldLeft(1)(_ * _)                            //> res17: Int = 0

  /*
	 * Map
	 */
  var m = Map(1 -> "a", 2 -> "b")                 //> m  : scala.collection.immutable.Map[Int,String] = Map(1 -> a, 2 -> b)
  m(1)                                            //> res18: String = a
  m.contains(2)                                   //> res19: Boolean = true
  m.keys                                          //> res20: Iterable[Int] = Set(1, 2)
  m.values                                        //> res21: Iterable[String] = MapLike.DefaultValuesIterable(a, b)
  // +, add a key-value pair in the Map
  m + (3 -> "c")                                  //> res22: scala.collection.immutable.Map[Int,String] = Map(1 -> a, 2 -> b, 3 -
                                                  //| > c)
  // remove a specific key-value pair from the Map
  m - (1)                                         //> res23: scala.collection.immutable.Map[Int,String] = Map(2 -> b)
  // add more than one key-value pairs in the Map
  m ++ List(3 -> "c", 4 -> "d")                   //> res24: scala.collection.immutable.Map[Int,String] = Map(1 -> a, 2 -> b, 3 -
                                                  //| > c, 4 -> d)
  // remove more than one key-value pairs from the Map
  m -- List(1, 2)                                 //> res25: scala.collection.immutable.Map[Int,String] = Map()

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
	 * Tuple
	 */
  var tuple1 = (103, "a", 10.5)                   //> tuple1  : (Int, String, Double) = (103,a,10.5)
  printf("%s owes us %.2f dollars\n", tuple1._2, tuple1._3)
                                                  //> a owes us 10.50 dollars
  tuple1.productIterator.foreach { println }      //> 103
                                                  //| a
                                                  //| 10.5
  tuple1.toString()                               //> res26: String = (103,a,10.5)

  /*
	 * Quicksort
	 */
  def quickSort(a: List[Int]): List[Int] =
    if (a.length < 2) a
    else quickSort(a.filter(_ < a.head)) ++ a.filter(_ == a.head) ++ quickSort(a.filter(_ > a.head))
                                                  //> quickSort: (a: List[Int])List[Int]

  quickSort(List(3, 2, 5, 1, 9, 8, 6, 7, 0, 4))   //> res27: List[Int] = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

}