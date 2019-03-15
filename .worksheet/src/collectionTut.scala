object collectionTut {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(55); val res$0 = 

  /*
   * Range
   */
	1 to 10;System.out.println("""res0: scala.collection.immutable.Range.Inclusive = """ + $show(res$0));$skip(14); val res$1 = 
	1 to 10 by 2;System.out.println("""res1: scala.collection.immutable.Range = """ + $show(res$1));$skip(18); val res$2 = 
	(1 to 10).toList;System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(12); val res$3 = 
	1 until 10;System.out.println("""res3: scala.collection.immutable.Range = """ + $show(res$3));$skip(59); 


  /*
   * Array
   */
  val intArr = new Array[Int](3);System.out.println("""intArr  : Array[Int] = """ + $show(intArr ));$skip(16); 
  intArr(0) = 1;$skip(16); 
  intArr(1) = 2;$skip(16); 
  intArr(2) = 3;$skip(78); 
  // or
  // val intArr = Array(1,2,3)
  for (i <- 0 to 2) println(intArr(i));$skip(90); 
  
  // Scala can deduce the type of the array implicitly
  var favNums = Array(1, 2, 3);System.out.println("""favNums  : Array[Int] = """ + $show(favNums ));$skip(27); 
  favNums.foreach(println);$skip(14); val res$4 = 
  favNums.sum;System.out.println("""res4: Int = """ + $show(res$4));$skip(14); val res$5 = 
  favNums.min;System.out.println("""res5: Int = """ + $show(res$5));$skip(14); val res$6 = 
  favNums.max;System.out.println("""res6: Int = """ + $show(res$6));$skip(49); val res$7 = 

  // descending sort
  favNums.sortWith(_ > _);System.out.println("""res7: Array[Int] = """ + $show(res$7));$skip(46); val res$8 = 
  // ascending sort
  favNums.sortWith(_ < _);System.out.println("""res8: Array[Int] = """ + $show(res$8));$skip(72); val res$9 = 
  // change to String separated by commas
  favNums.deep.mkString(", ");System.out.println("""res9: String = """ + $show(res$9));$skip(88); 

	// two-dimensional array
	val myMatrix = Array.ofDim[Int](3, 4)  // 3 rows 4 columns
	
  /*
   * ArrayBuffer
   */
	import scala.collection.mutable.ArrayBuffer;System.out.println("""myMatrix  : Array[Array[Int]] = """ + $show(myMatrix ));$skip(115); 
	val myMutableArr = ArrayBuffer(1,2,3);System.out.println("""myMutableArr  : scala.collection.mutable.ArrayBuffer[Int] = """ + $show(myMutableArr ));$skip(43); val res$10 = 
	// append 4 at the end
	myMutableArr += 4;System.out.println("""res10: collectionTut.myMutableArr.type = """ + $show(res$10));$skip(64); 
	// insert 20 and 21 at index 2
	myMutableArr.insert(2, 20, 21);$skip(23); 
	println(myMutableArr);$skip(42); val res$11 = 
	// remove the first 3
	myMutableArr -= 3;System.out.println("""res11: collectionTut.myMutableArr.type = """ + $show(res$11));$skip(58); val res$12 = 
	// remove the element of index 1
	myMutableArr.remove(1);System.out.println("""res12: Int = """ + $show(res$12));$skip(23); 
	println(myMutableArr);$skip(60); 
	
	
	
	/*
	 * Tuple
	 */
  var tuple1 = (103, "a", 10.5);System.out.println("""tuple1  : (Int, String, Double) = """ + $show(tuple1 ));$skip(60); 
  printf("%s owes us %.2f dollars\n", tuple1._2, tuple1._3);$skip(45); 
  tuple1.productIterator.foreach { println };$skip(20); val res$13 = 
  tuple1.toString();System.out.println("""res13: String = """ + $show(res$13));$skip(370); 
  
  // t is (0, 0d, 0d)
  // v is the input param
  // t._1 + 1: 0 + 1, three times, result is 3
  // t._2 + v: 0d + 1.0 + 2.0 + 3.0, result is 6.0
  // t._3 + v * v: 0d + 1.0 * 1.0 + 2.0 * 2.0 + 3.0 * 3.0, result is 14.0
  def sumSq(inputParam: List[Double]): (Int, Double, Double) =
  		inputParam.foldLeft((0, 0d, 0d))((t, v) => (t._1 + 1, t._2 + v, t._3 + v * v));System.out.println("""sumSq: (inputParam: List[Double])(Int, Double, Double)""");$skip(36); val res$14 = 
  		
  	sumSq(List(1.0, 2.0, 3.0));System.out.println("""res14: (Int, Double, Double) = """ + $show(res$14));$skip(48); 
	
  /*
   * List
   */
  var a = List(1, 2, 3);System.out.println("""a  : List[Int] = """ + $show(a ));$skip(47); val res$15 = 
  // another way to form a list
  1::2::3::Nil;System.out.println("""res15: List[Int] = """ + $show(res$15));$skip(64); 
  // ::, add an element at the beginning of a list
  a = 0 :: a;$skip(13); 
  println(a);$skip(54); 
  // add an element at the end of a list
  a = a :+ 4;$skip(13); 
  println(a);$skip(29); 
  
  
  var b = List(5, 6);System.out.println("""b  : List[Int] = """ + $show(b ));$skip(42); 
  // :::, connect two lists
  b = b ::: a;$skip(21); 
  // or
  b = b ++ a;$skip(12); 
	println(b);$skip(244); 
	
	
  // list.head, get the first element in the list
  // list.tail, get remaining elements in the list after the first one
  def walkthru(l: List[Int]): String = {
    if (l.isEmpty) ""
    else l.head.toString + " " + walkthru(l.tail)
  };System.out.println("""walkthru: (l: List[Int])String""");$skip(16); val res$16 = 

  walkthru(b);System.out.println("""res16: String = """ + $show(res$16));$skip(63); val res$17 = 

  // get odd numbers in the list
  a.filter(x => x % 2 == 1);System.out.println("""res17: List[Int] = """ + $show(res$17));$skip(102); val res$18 = 

  // get digital numbers in the string
  "99 Red Balloons".toList.filter(x => Character.isDigit(x));System.out.println("""res18: List[Char] = """ + $show(res$18));$skip(95); val res$19 = 
  // get elements until the element is 'B'
  "99 Red Balloons".toList.takeWhile(x => x != 'B');System.out.println("""res19: List[Char] = """ + $show(res$19));$skip(32); 

  var c = List("x", "y", "z");System.out.println("""c  : List[String] = """ + $show(c ));$skip(28); val res$20 = 
  c.map(x => x.toUpperCase);System.out.println("""res20: List[String] = """ + $show(res$20));$skip(40); val res$21 = 
  c.map(_.toUpperCase);System.out.println("""res21: List[String] = """ + $show(res$21));$skip(37); val res$22 =  // short version

  a.filter(_ % 2 == 1).map(_ + 10);System.out.println("""res22: List[Int] = """ + $show(res$22));$skip(23); 

  var q = List(a, b);System.out.println("""q  : List[List[Int]] = """ + $show(q ));$skip(30); val res$23 = 
  q.map(_.filter(_ % 2 == 1));System.out.println("""res23: List[List[Int]] = """ + $show(res$23));$skip(88); val res$24 = 
  // flatMap is used to merge two lists in the result
  q.flatMap(_.filter(_ % 2 == 1));System.out.println("""res24: List[Int] = """ + $show(res$24));$skip(24); val res$25 = 

  a.reduceLeft(_ + _);System.out.println("""res25: Int = """ + $show(res$25));$skip(48); val res$26 = 
  // with start value: 0
  a.foldLeft(0)(_ + _);System.out.println("""res26: Int = """ + $show(res$26));$skip(48); val res$27 = 
  // with start value: 1
  a.foldLeft(1)(_ * _);System.out.println("""res27: Int = """ + $show(res$27));$skip(54); 

  /*
	 * Map
	 */
  var m = Map(1 -> "a", 2 -> "b");System.out.println("""m  : scala.collection.immutable.Map[Int,String] = """ + $show(m ));$skip(7); val res$28 = 
  m(1);System.out.println("""res28: String = """ + $show(res$28));$skip(16); val res$29 = 
  m.contains(2);System.out.println("""res29: Boolean = """ + $show(res$29));$skip(9); val res$30 = 
  m.keys;System.out.println("""res30: Iterable[Int] = """ + $show(res$30));$skip(11); val res$31 = 
  m.values;System.out.println("""res31: Iterable[String] = """ + $show(res$31));$skip(57); val res$32 = 
  // +, add a key-value pair in the Map
  m + (3 -> "c");System.out.println("""res32: scala.collection.immutable.Map[Int,String] = """ + $show(res$32));$skip(68); val res$33 = 
  // remove a specific key-value pair from the Map by key
  m - (1);System.out.println("""res33: scala.collection.immutable.Map[Int,String] = """ + $show(res$33));$skip(82); val res$34 = 
  // add more than one key-value pairs in the Map
  m ++ List(3 -> "c", 4 -> "d");System.out.println("""res34: scala.collection.immutable.Map[Int,String] = """ + $show(res$34));$skip(81); val res$35 = 
  // remove more than one key-value pairs from the Map by keys
  m -- List(1, 2);System.out.println("""res35: scala.collection.immutable.Map[Int,String] = """ + $show(res$35));$skip(84); 

  // mutable Map
  var customers = collection.mutable.Map(100 -> "a", 101 -> "b");System.out.println("""customers  : scala.collection.mutable.Map[Int,String] = """ + $show(customers ));$skip(41); 
  printf("Cust 1: %s\n", customers(100));$skip(23); 
  customers(100) = "A";$skip(23); 
  customers(101) = "b";$skip(53); 
  for ((k, v) <- customers) printf("%d: %s\n", k, v);$skip(134); 


  /*
	 * Stream
	 * Stream is a lazy List that only the first element is computed.
	 */
	val str = 1 #:: 2 #:: 3 #:: Stream.empty;System.out.println("""str  : scala.collection.immutable.Stream[Int] = """ + $show(str ));$skip(39); 
	val stream = (1 to 10000000).toStream;System.out.println("""stream  : scala.collection.immutable.Stream[Int] = """ + $show(stream ));$skip(13); val res$36 = 
	stream.head;System.out.println("""res36: Int = """ + $show(res$36));$skip(13); val res$37 = 
	stream.tail;System.out.println("""res37: scala.collection.immutable.Stream[Int] = """ + $show(res$37));$skip(194); 

  /*
	 * Quicksort
	 */
  def quickSort(a: List[Int]): List[Int] =
    if (a.length < 2) a
    else quickSort(a.filter(_ < a.head)) ++ a.filter(_ == a.head) ++ quickSort(a.filter(_ > a.head));System.out.println("""quickSort: (a: List[Int])List[Int]""");$skip(50); val res$38 = 

  quickSort(List(3, 2, 5, 1, 9, 8, 6, 7, 0, 4));System.out.println("""res38: List[Int] = """ + $show(res$38))}

}
