object collection {
  var a = List(1, 2, 3)                           //> a  : List[Int] = List(1, 2, 3)
  // ::, add an element at the beginning of a list
  a = 0 :: a
  a                                               //> res0: List[Int] = List(0, 1, 2, 3)
  var b = List(5, 6)                              //> b  : List[Int] = List(5, 6)
  // :::, connect two lists
  b = b ::: a
  b                                               //> res1: List[Int] = List(5, 6, 0, 1, 2, 3)
  
  // list.head, get the first element in the list
  // list.tail, get remaining elements in the list after the first one
  def walkthru(l: List[Int]): String = {
  	if (l.isEmpty) ""
  	else l.head.toString + " " + walkthru(l.tail)
  }                                               //> walkthru: (l: List[Int])String
  
  walkthru(b)                                     //> res2: String = "5 6 0 1 2 3 "
  
  
  // get odd numbers in the list
  a.filter(x => x % 2 == 1)                       //> res3: List[Int] = List(1, 3)
  
  
  // get digital numbers in the string
  "99 Red Balloons".toList.filter(x => Character.isDigit(x))
                                                  //> res4: List[Char] = List(9, 9)
  // get elements until the element is 'B'
  "99 Red Balloons".toList.takeWhile(x => x != 'B')
                                                  //> res5: List[Char] = List(9, 9,  , R, e, d,  )
         
  
  var c = List("x", "y", "z")                     //> c  : List[String] = List(x, y, z)
  c.map(x => x.toUpperCase)                       //> res6: List[String] = List(X, Y, Z)
  c.map(_.toUpperCase) // short version           //> res7: List[String] = List(X, Y, Z)
  
  
  a.filter(_ % 2 == 1).map(_ + 10)                //> res8: List[Int] = List(11, 13)
  
  
  var q = List(a, b)                              //> q  : List[List[Int]] = List(List(0, 1, 2, 3), List(5, 6, 0, 1, 2, 3))
  q.map(_.filter(_ % 2 == 1))                     //> res9: List[List[Int]] = List(List(1, 3), List(5, 1, 3))
  // flatMap is used to merge two lists in the result
  q.flatMap(_.filter(_ % 2 == 1))                 //> res10: List[Int] = List(1, 3, 5, 1, 3)


	a.reduceLeft(_ + _)                       //> res11: Int = 6
	a.foldLeft(0)(_ + _)                      //> res12: Int = 6
	a.foldLeft(1)(_ * _)                      //> res13: Int = 0
	
	
	
	var m = Map(1 -> "a", 2 -> "b")           //> m  : scala.collection.immutable.Map[Int,String] = Map(1 -> a, 2 -> b)
	m(1)                                      //> res14: String = a
	m.contains(2)                             //> res15: Boolean = true
	m.keys                                    //> res16: Iterable[Int] = Set(1, 2)
	m.values                                  //> res17: Iterable[String] = MapLike.DefaultValuesIterable(a, b)
	// +, add a key-value pair in the Map
	m + (3 -> "c")                            //> res18: scala.collection.immutable.Map[Int,String] = Map(1 -> a, 2 -> b, 3 -
                                                  //| > c)
  // remove a specific key-value pair from the Map
	m - (1)                                   //> res19: scala.collection.immutable.Map[Int,String] = Map(2 -> b)
	// add more than one key-value pairs in the Map
	m ++ List(3 -> "c", 4 -> "d")             //> res20: scala.collection.immutable.Map[Int,String] = Map(1 -> a, 2 -> b, 3 -
                                                  //| > c, 4 -> d)
  // remove more than one key-value pairs from the Map
	m -- List(1, 2)                           //> res21: scala.collection.immutable.Map[Int,String] = Map()
	
	
	
	// quicksort
	def quickSort(a: List[Int]): List[Int] =
		if (a.length < 2) a
		else quickSort(a.filter(_ < a.head)) ++ a.filter(_ == a.head) ++ quickSort(a.filter(_ > a.head))
                                                  //> quickSort: (a: List[Int])List[Int]
	
	quickSort(List(3, 2, 5, 1, 9, 8, 6, 7, 0, 4))
                                                  //> res22: List[Int] = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
  
}