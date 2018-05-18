object basic {
  val l = List("aaaa", "b", "c")                  //> l  : List[String] = List(aaaa, b, c)
  
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
    
  
  val result_try = try {
  	Integer.parseInt("Dog")
  } catch {
  	case _ => 0
  } finally {
  	println("This is finally.")
  }                                               //> This is finally.
                                                  //| result_try  : Int = 0
  
  val code = 1                                    //> code  : Int = 1
  val result_match = code match {
  	case 1 => "one"
  	case 2 => "two"
  	case _ => "others"
  }                                               //> result_match  : String = one
  

  // higher-order function
  def greeting() = (name: String) => {"hi " + name}
                                                  //> greeting: ()String => String
  greeting()("LZ")                                //> res1: String = hi LZ
  
  

  // anonymous function
  (x: Int) => {x * x}                             //> res2: Int => Int = basic$$$Lambda$21/748658608@2096442d
  
  var add = (x: Int, y: Int) => x + y             //> add  : (Int, Int) => Int = basic$$$Lambda$22/1358444045@2cb4c3ab
  add(1, 2)                                       //> res3: Int = 3


	// Curried Function
	def curriedAdd(a: Int)(b: Int) = a + b    //> curriedAdd: (a: Int)(b: Int)Int
	curriedAdd(2)(3)                          //> res4: Int = 5
	
	val addOne = curriedAdd(1)_               //> addOne  : Int => Int = basic$$$Lambda$23/331844619@12843fce
	addOne(2)                                 //> res5: Int = 3
}