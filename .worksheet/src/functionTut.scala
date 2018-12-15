object functionTut {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(84); 
  def hello(name: String): String = {
    s"Hello, ${name}"
  };System.out.println("""hello: (name: String)String""");$skip(14); val res$0 = 
  hello("LZ");System.out.println("""res0: String = """ + $show(res$0));$skip(102); 

  // do not need to specify the return type
  def hello2(name: String) = {
    s"Hello, ${name}"
  };System.out.println("""hello2: (name: String)String""");$skip(152); 

  // receive various input arguments
  def getSum(args: Int*): Int = {
    var sum: Int = 0
    for (num <- args) {
      sum += num
    }
    sum
  };System.out.println("""getSum: (args: Int*)Int""");$skip(40); 
  println("Get sum " + getSum(1, 2, 3));$skip(93); 

  /*
   * higher-order function
   */
  def greeting() = (name: String) => { "hi " + name };System.out.println("""greeting: ()String => String""");$skip(19); val res$1 = 
  greeting()("LZ");System.out.println("""res1: String = """ + $show(res$1));$skip(60); val res$2 = 

  /*
   * anonymous function
   */
  (x: Int) => { x * x };System.out.println("""res2: Int => Int = """ + $show(res$2));$skip(39); 

  var add = (x: Int, y: Int) => x + y;System.out.println("""add  : (Int, Int) => Int = """ + $show(add ));$skip(12); val res$3 = 
  add(1, 2);System.out.println("""res3: Int = """ + $show(res$3));$skip(73); 

  /*
	 * Curried Function
	 */
  def curriedAdd(a: Int)(b: Int) = a + b;System.out.println("""curriedAdd: (a: Int)(b: Int)Int""");$skip(19); val res$4 = 
  curriedAdd(2)(3);System.out.println("""res4: Int = """ + $show(res$4));$skip(31); 

  val addOne = curriedAdd(1)_;System.out.println("""addOne  : Int => Int = """ + $show(addOne ));$skip(12); val res$5 = 
  addOne(2);System.out.println("""res5: Int = """ + $show(res$5))}
}
