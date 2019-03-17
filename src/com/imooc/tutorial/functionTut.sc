object functionTut {
  def hello(name: String): String = {
    s"Hello, ${name}"
  }                                               //> hello: (name: String)String
  hello("LZ")                                     //> res0: String = Hello, LZ

  // do not need to specify the return type
  def hello2(name: String) = {
    s"Hello, ${name}"
  }                                               //> hello2: (name: String)String

  // receive various input arguments
  def getSum(args: Int*): Int = {
    var sum: Int = 0
    for (num <- args) {
      sum += num
    }
    sum
  }                                               //> getSum: (args: Int*)Int
  println("Get sum " + getSum(1, 2, 3))           //> Get sum 6

  /*
   * higher-order function
   */
  def greeting() = (name: String) => { "hi " + name }
                                                  //> greeting: ()String => String
  greeting()("LZ")                                //> res1: String = hi LZ

val salaries = Seq(20000, 70000, 40000)           //> salaries  : Seq[Int] = List(20000, 70000, 40000)
val doubleSalary = (x: Int) => x * 2              //> doubleSalary  : Int => Int = functionTut$$$Lambda$14/99347477@21bcffb5
val newSalaries = salaries.map(doubleSalary) // List(40000, 140000, 80000)
                                                  //> newSalaries  : Seq[Int] = List(40000, 140000, 80000)


  /*
   * anonymous function
   */
  (x: Int) => { x * x }                           //> res2: Int => Int = functionTut$$$Lambda$16/2052915500@3fb6a447

  var add = (x: Int, y: Int) => x + y             //> add  : (Int, Int) => Int = functionTut$$$Lambda$17/785992331@38082d64
  add(1, 2)                                       //> res3: Int = 3

  /*
	 * Curried Function
	 */
  def curriedAdd(a: Int)(b: Int) = a + b          //> curriedAdd: (a: Int)(b: Int)Int
  curriedAdd(2)(3)                                //> res4: Int = 5

  val addOne = curriedAdd(1)_                     //> addOne  : Int => Int = functionTut$$$Lambda$18/234698513@42d3bd8b
  addOne(2)                                       //> res5: Int = 3
  
  /*
	 * Partial Application
	 */
val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10) //> numbers  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
val numberFunc = numbers.foldLeft(List[Int]()) _  //> numberFunc  : ((List[Int], Int) => List[Int]) => List[Int] = functionTut$$$
                                                  //| Lambda$19/998351292@64616ca2

val squares = numberFunc((xs, x) => xs :+ x*x)    //> squares  : List[Int] = List(1, 4, 9, 16, 25, 36, 49, 64, 81, 100)
print(squares)                                    //> List(1, 4, 9, 16, 25, 36, 49, 64, 81, 100)

val cubes = numberFunc((xs, x) => xs :+ x*x*x)    //> cubes  : List[Int] = List(1, 8, 27, 64, 125, 216, 343, 512, 729, 1000)
print(cubes)
}