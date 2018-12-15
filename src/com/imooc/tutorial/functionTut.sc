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

  /*
   * anonymous function
   */
  (x: Int) => { x * x }                           //> res2: Int => Int = functionTut$$$Lambda$11/434091818@6fadae5d

  var add = (x: Int, y: Int) => x + y             //> add  : (Int, Int) => Int = functionTut$$$Lambda$12/1349414238@96532d6
  add(1, 2)                                       //> res3: Int = 3

  /*
	 * Curried Function
	 */
  def curriedAdd(a: Int)(b: Int) = a + b          //> curriedAdd: (a: Int)(b: Int)Int
  curriedAdd(2)(3)                                //> res4: Int = 5

  val addOne = curriedAdd(1)_                     //> addOne  : Int => Int = functionTut$$$Lambda$13/932607259@67b64c45
  addOne(2)                                       //> res5: Int = 3
}