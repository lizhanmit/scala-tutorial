object basic {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(47); 
  val l = List("aaaa", "b", "c");System.out.println("""l  : List[String] = """ + $show(l ));$skip(80); 
  
  for {
  	i <- l // generator, for each element in the list
  } println (i);$skip(67); 
  
  for {
  	i <- l
		if (i.length > 3) // filter
  } println (i);$skip(146); 
  
  
  val result_for = for {
  	i <- l
  	i1 = i.toUpperCase() // variable binding
  	if (i1 != "")
  } yield (i1);System.out.println("""result_for  : List[String] = """ + $show(result_for ));$skip(16); val res$0 =  // generate a new collection
  
  result_for;System.out.println("""res0: List[String] = """ + $show(res$0));$skip(116); 
  
  
  
  // until is often used to loop through strings or arrays
	val randLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";System.out.println("""randLetters  : String = """ + $show(randLetters ));$skip(113); 
	for (i <- 0 until randLetters.length){
		// Get the letter in the index of the String
		println(randLetters(i))
	};$skip(139); 
    
  
  val result_try = try {
  	Integer.parseInt("Dog")
  } catch {
  	case _ => 0
  } finally {
  	println("This is finally.")
  };System.out.println("""result_try  : Int = """ + $show(result_try ));$skip(18); 
  
  val code = 1;System.out.println("""code  : Int = """ + $show(code ));$skip(98); 
  val result_match = code match {
  	case 1 => "one"
  	case 2 => "two"
  	case _ => "others"
  };System.out.println("""result_match  : String = """ + $show(result_match ));$skip(83); 
  

  // higher-order function
  def greeting() = (name: String) => {"hi " + name};System.out.println("""greeting: ()String => String""");$skip(19); val res$1 = 
  greeting()("LZ");System.out.println("""res1: String = """ + $show(res$1));$skip(53); val res$2 = 
  
  

  // anonymous function
  (x: Int) => {x * x};System.out.println("""res2: Int => Int = """ + $show(res$2));$skip(41); 
  
  var add = (x: Int, y: Int) => x + y;System.out.println("""add  : (Int, Int) => Int = """ + $show(add ));$skip(12); val res$3 = 
  add(1, 2);System.out.println("""res3: Int = """ + $show(res$3));$skip(63); 


	// Curried Function
	def curriedAdd(a: Int)(b: Int) = a + b;System.out.println("""curriedAdd: (a: Int)(b: Int)Int""");$skip(18); val res$4 = 
	curriedAdd(2)(3);System.out.println("""res4: Int = """ + $show(res$4));$skip(31); 
	
	val addOne = curriedAdd(1)_;System.out.println("""addOne  : Int => Int = """ + $show(addOne ));$skip(11); val res$5 = 
	addOne(2);System.out.println("""res5: Int = """ + $show(res$5))}
}
