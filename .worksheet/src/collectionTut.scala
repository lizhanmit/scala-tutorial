object collectionTut {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(75); 
  /*
   * Array
   */
  var favNums = Array(1, 2, 3);System.out.println("""favNums  : Array[Int] = """ + $show(favNums ));$skip(27); 
  favNums.foreach(println);$skip(14); val res$0 = 
  favNums.sum;System.out.println("""res0: Int = """ + $show(res$0));$skip(14); val res$1 = 
  favNums.min;System.out.println("""res1: Int = """ + $show(res$1));$skip(14); val res$2 = 
  favNums.max;System.out.println("""res2: Int = """ + $show(res$2));$skip(48); val res$3 = 

  // descending sort
  favNums.sortWith(_ > _);System.out.println("""res3: Array[Int] = """ + $show(res$3));$skip(46); val res$4 = 
  // ascending sort
  favNums.sortWith(_ < _);System.out.println("""res4: Array[Int] = """ + $show(res$4));$skip(72); val res$5 = 
  // change to String separated by commas
  favNums.deep.mkString(", ");System.out.println("""res5: String = """ + $show(res$5));$skip(46); 

  /*
   * List
   */
  var a = List(1, 2, 3);System.out.println("""a  : List[Int] = """ + $show(a ));$skip(64); 
  // ::, add an element at the beginning of a list
  a = 0 :: a;$skip(13); 
  println(a);$skip(24); 
  
  var b = List(5, 6);System.out.println("""b  : List[Int] = """ + $show(b ));$skip(42); 
  // :::, connect two lists
  b = b ::: a;$skip(35); 
  // or
  //b = b ++ a
	println(b);$skip(242); 
	
	
  // list.head, get the first element in the list
  // list.tail, get remaining elements in the list after the first one
  def walkthru(l: List[Int]): String = {
    if (l.isEmpty) ""
    else l.head.toString + " " + walkthru(l.tail)
  };System.out.println("""walkthru: (l: List[Int])String""");$skip(15); val res$6 = 

  walkthru(b);System.out.println("""res6: String = """ + $show(res$6));$skip(62); val res$7 = 

  // get odd numbers in the list
  a.filter(x => x % 2 == 1);System.out.println("""res7: List[Int] = """ + $show(res$7));$skip(101); val res$8 = 

  // get digital numbers in the string
  "99 Red Balloons".toList.filter(x => Character.isDigit(x));System.out.println("""res8: List[Char] = """ + $show(res$8));$skip(95); val res$9 = 
  // get elements until the element is 'B'
  "99 Red Balloons".toList.takeWhile(x => x != 'B');System.out.println("""res9: List[Char] = """ + $show(res$9));$skip(31); 

  var c = List("x", "y", "z");System.out.println("""c  : List[String] = """ + $show(c ));$skip(28); val res$10 = 
  c.map(x => x.toUpperCase);System.out.println("""res10: List[String] = """ + $show(res$10));$skip(40); val res$11 = 
  c.map(_.toUpperCase);System.out.println("""res11: List[String] = """ + $show(res$11));$skip(36); val res$12 =  // short version

  a.filter(_ % 2 == 1).map(_ + 10);System.out.println("""res12: List[Int] = """ + $show(res$12));$skip(22); 

  var q = List(a, b);System.out.println("""q  : List[List[Int]] = """ + $show(q ));$skip(30); val res$13 = 
  q.map(_.filter(_ % 2 == 1));System.out.println("""res13: List[List[Int]] = """ + $show(res$13));$skip(88); val res$14 = 
  // flatMap is used to merge two lists in the result
  q.flatMap(_.filter(_ % 2 == 1));System.out.println("""res14: List[Int] = """ + $show(res$14));$skip(23); val res$15 = 

  a.reduceLeft(_ + _);System.out.println("""res15: Int = """ + $show(res$15));$skip(23); val res$16 = 
  a.foldLeft(0)(_ + _);System.out.println("""res16: Int = """ + $show(res$16));$skip(23); val res$17 = 
  a.foldLeft(1)(_ * _);System.out.println("""res17: Int = """ + $show(res$17));$skip(53); 

  /*
	 * Map
	 */
  var m = Map(1 -> "a", 2 -> "b");System.out.println("""m  : scala.collection.immutable.Map[Int,String] = """ + $show(m ));$skip(7); val res$18 = 
  m(1);System.out.println("""res18: String = """ + $show(res$18));$skip(16); val res$19 = 
  m.contains(2);System.out.println("""res19: Boolean = """ + $show(res$19));$skip(9); val res$20 = 
  m.keys;System.out.println("""res20: Iterable[Int] = """ + $show(res$20));$skip(11); val res$21 = 
  m.values;System.out.println("""res21: Iterable[String] = """ + $show(res$21));$skip(57); val res$22 = 
  // +, add a key-value pair in the Map
  m + (3 -> "c");System.out.println("""res22: scala.collection.immutable.Map[Int,String] = """ + $show(res$22));$skip(61); val res$23 = 
  // remove a specific key-value pair from the Map
  m - (1);System.out.println("""res23: scala.collection.immutable.Map[Int,String] = """ + $show(res$23));$skip(82); val res$24 = 
  // add more than one key-value pairs in the Map
  m ++ List(3 -> "c", 4 -> "d");System.out.println("""res24: scala.collection.immutable.Map[Int,String] = """ + $show(res$24));$skip(73); val res$25 = 
  // remove more than one key-value pairs from the Map
  m -- List(1, 2);System.out.println("""res25: scala.collection.immutable.Map[Int,String] = """ + $show(res$25));$skip(83); 

  // mutable Map
  var customers = collection.mutable.Map(100 -> "a", 101 -> "b");System.out.println("""customers  : scala.collection.mutable.Map[Int,String] = """ + $show(customers ));$skip(41); 
  printf("Cust 1: %s\n", customers(100));$skip(23); 
  customers(100) = "A";$skip(23); 
  customers(101) = "b";$skip(53); 
  for ((k, v) <- customers) printf("%d: %s\n", k, v);$skip(53); 

  /*
	 * Tuple
	 */
  var tuple1 = (103, "a", 10.5);System.out.println("""tuple1  : (Int, String, Double) = """ + $show(tuple1 ));$skip(60); 
  printf("%s owes us %.2f dollars\n", tuple1._2, tuple1._3);$skip(45); 
  tuple1.productIterator.foreach { println };$skip(20); val res$26 = 
  tuple1.toString();System.out.println("""res26: String = """ + $show(res$26));$skip(193); 

  /*
	 * Quicksort
	 */
  def quickSort(a: List[Int]): List[Int] =
    if (a.length < 2) a
    else quickSort(a.filter(_ < a.head)) ++ a.filter(_ == a.head) ++ quickSort(a.filter(_ > a.head));System.out.println("""quickSort: (a: List[Int])List[Int]""");$skip(49); val res$27 = 

  quickSort(List(3, 2, 5, 1, 9, 8, 6, 7, 0, 4));System.out.println("""res27: List[Int] = """ + $show(res$27))}

}
