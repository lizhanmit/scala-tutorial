object collection {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(43); 
  var a = List(1, 2, 3);System.out.println("""a  : List[Int] = """ + $show(a ));$skip(64); 
  // ::, add an element at the beginning of a list
  a = 0 :: a;$skip(4); val res$0 = 
  a;System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(21); 
  var b = List(5, 6);System.out.println("""b  : List[Int] = """ + $show(b ));$skip(42); 
  // :::, connect two lists
  b = b ::: a;$skip(4); val res$1 = 
  b;System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(239); 
  
  // list.head, get the first element in the list
  // list.tail, get remaining elements in the list after the first one
  def walkthru(l: List[Int]): String = {
  	if (l.isEmpty) ""
  	else l.head.toString + " " + walkthru(l.tail)
  };System.out.println("""walkthru: (l: List[Int])String""");$skip(17); val res$2 = 
  
  walkthru(b);System.out.println("""res2: String = """ + $show(res$2));$skip(67); val res$3 = 
  
  
  // get odd numbers in the list
  a.filter(x => x % 2 == 1);System.out.println("""res3: List[Int] = """ + $show(res$3));$skip(106); val res$4 = 
  
  
  // get digital numbers in the string
  "99 Red Balloons".toList.filter(x => Character.isDigit(x));System.out.println("""res4: List[Char] = """ + $show(res$4));$skip(95); val res$5 = 
  // get elements until the element is 'B'
  "99 Red Balloons".toList.takeWhile(x => x != 'B');System.out.println("""res5: List[Char] = """ + $show(res$5));$skip(43); 
         
  
  var c = List("x", "y", "z");System.out.println("""c  : List[String] = """ + $show(c ));$skip(28); val res$6 = 
  c.map(x => x.toUpperCase);System.out.println("""res6: List[String] = """ + $show(res$6));$skip(40); val res$7 = 
  c.map(_.toUpperCase);System.out.println("""res7: List[String] = """ + $show(res$7));$skip(41); val res$8 =  // short version
  
  
  a.filter(_ % 2 == 1).map(_ + 10);System.out.println("""res8: List[Int] = """ + $show(res$8));$skip(27); 
  
  
  var q = List(a, b);System.out.println("""q  : List[List[Int]] = """ + $show(q ));$skip(30); val res$9 = 
  q.map(_.filter(_ % 2 == 1));System.out.println("""res9: List[List[Int]] = """ + $show(res$9));$skip(88); val res$10 = 
  // flatMap is used to merge two lists in the result
  q.flatMap(_.filter(_ % 2 == 1));System.out.println("""res10: List[Int] = """ + $show(res$10));$skip(23); val res$11 = 


	a.reduceLeft(_ + _);System.out.println("""res11: Int = """ + $show(res$11));$skip(22); val res$12 = 
	a.foldLeft(0)(_ + _);System.out.println("""res12: Int = """ + $show(res$12));$skip(22); val res$13 = 
	a.foldLeft(1)(_ * _);System.out.println("""res13: Int = """ + $show(res$13));$skip(39); 
	
	
	
	var m = Map(1 -> "a", 2 -> "b");System.out.println("""m  : scala.collection.immutable.Map[Int,String] = """ + $show(m ));$skip(6); val res$14 = 
	m(1);System.out.println("""res14: String = """ + $show(res$14));$skip(15); val res$15 = 
	m.contains(2);System.out.println("""res15: Boolean = """ + $show(res$15));$skip(8); val res$16 = 
	m.keys;System.out.println("""res16: Iterable[Int] = """ + $show(res$16));$skip(10); val res$17 = 
	m.values;System.out.println("""res17: Iterable[String] = """ + $show(res$17));$skip(55); val res$18 = 
	// +, add a key-value pair in the Map
	m + (3 -> "c");System.out.println("""res18: scala.collection.immutable.Map[Int,String] = """ + $show(res$18));$skip(60); val res$19 = 
  // remove a specific key-value pair from the Map
	m - (1);System.out.println("""res19: scala.collection.immutable.Map[Int,String] = """ + $show(res$19));$skip(80); val res$20 = 
	// add more than one key-value pairs in the Map
	m ++ List(3 -> "c", 4 -> "d");System.out.println("""res20: scala.collection.immutable.Map[Int,String] = """ + $show(res$20));$skip(72); val res$21 = 
  // remove more than one key-value pairs from the Map
	m -- List(1, 2);System.out.println("""res21: scala.collection.immutable.Map[Int,String] = """ + $show(res$21));$skip(183); 
	
	
	
	// quicksort
	def quickSort(a: List[Int]): List[Int] =
		if (a.length < 2) a
		else quickSort(a.filter(_ < a.head)) ++ a.filter(_ == a.head) ++ quickSort(a.filter(_ > a.head));System.out.println("""quickSort: (a: List[Int])List[Int]""");$skip(49); val res$22 = 
	
	quickSort(List(3, 2, 5, 1, 9, 8, 6, 7, 0, 4));System.out.println("""res22: List[Int] = """ + $show(res$22))}
  
}
