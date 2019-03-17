object functionTut {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(84); 
  def hello(name: String): String = {
    s"Hello, ${name}"
  };System.out.println("""hello: (name: String)String""");$skip(14); val res$0 = 
  hello("LZ");System.out.println("""res0: String = """ + $show(res$0));$skip(103); 

  // do not need to specify the return type
  def hello2(name: String) = {
    s"Hello, ${name}"
  };System.out.println("""hello2: (name: String)String""");$skip(153); 

  // receive various input arguments
  def getSum(args: Int*): Int = {
    var sum: Int = 0
    for (num <- args) {
      sum += num
    }
    sum
  };System.out.println("""getSum: (args: Int*)Int""");$skip(40); 
  println("Get sum " + getSum(1, 2, 3));$skip(94); 

  /*
   * higher-order function
   */
  def greeting() = (name: String) => { "hi " + name };System.out.println("""greeting: ()String => String""");$skip(19); val res$1 = 
  greeting()("LZ");System.out.println("""res1: String = """ + $show(res$1));$skip(42); 

val salaries = Seq(20000, 70000, 40000);System.out.println("""salaries  : Seq[Int] = """ + $show(salaries ));$skip(37); 
val doubleSalary = (x: Int) => x * 2;System.out.println("""doubleSalary  : Int => Int = """ + $show(doubleSalary ));$skip(75); 
val newSalaries = salaries.map(doubleSalary);System.out.println("""newSalaries  : Seq[Int] = """ + $show(newSalaries ));$skip(63); val res$2 =  // List(40000, 140000, 80000)


  /*
   * anonymous function
   */
  (x: Int) => { x * x };System.out.println("""res2: Int => Int = """ + $show(res$2));$skip(40); 

  var add = (x: Int, y: Int) => x + y;System.out.println("""add  : (Int, Int) => Int = """ + $show(add ));$skip(12); val res$3 = 
  add(1, 2);System.out.println("""res3: Int = """ + $show(res$3));$skip(74); 

  /*
	 * Curried Function
	 */
  def curriedAdd(a: Int)(b: Int) = a + b;System.out.println("""curriedAdd: (a: Int)(b: Int)Int""");$skip(19); val res$4 = 
  curriedAdd(2)(3);System.out.println("""res4: Int = """ + $show(res$4));$skip(32); 

  val addOne = curriedAdd(1)_;System.out.println("""addOne  : Int => Int = """ + $show(addOne ));$skip(12); val res$5 = 
  addOne(2);System.out.println("""res5: Int = """ + $show(res$5));$skip(87); 
  
  /*
	 * Partial Application
	 */
val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);System.out.println("""numbers  : List[Int] = """ + $show(numbers ));$skip(49); 
val numberFunc = numbers.foldLeft(List[Int]()) _;System.out.println("""numberFunc  : ((List[Int], Int) => List[Int]) => List[Int] = """ + $show(numberFunc ));$skip(48); 

val squares = numberFunc((xs, x) => xs :+ x*x);System.out.println("""squares  : List[Int] = """ + $show(squares ));$skip(15); 
print(squares);$skip(48); 

val cubes = numberFunc((xs, x) => xs :+ x*x*x);System.out.println("""cubes  : List[Int] = """ + $show(cubes ));$skip(13); 
print(cubes)}
}
