object LearningScala3 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(223); 
  // Functions

  // Format is def <function name>(parameter name: type...) : return type = { expression }
  // Don't forget the = before the expression!
  def squareIt(x: Int): Int = {
    x * x
  };System.out.println("""squareIt: (x: Int)Int""");$skip(43); 

  def cubeIt(x: Int): Int = { x * x * x };System.out.println("""cubeIt: (x: Int)Int""");$skip(24); 

  println(squareIt(2));$skip(22); 

  println(cubeIt(2));$skip(120); 

  // Functions can take other functions as parameters

  def transformInt(x: Int, f: Int => Int): Int = {
    f(x)
  };System.out.println("""transformInt: (x: Int, f: Int => Int)Int""");$skip(40); 

  val result = transformInt(2, cubeIt);System.out.println("""result  : Int = """ + $show(result ));$skip(18); 
  println(result);$skip(207); val res$0 = 

  // "Lambda functions", "anonymous functions", "function literals"
  // You can declare functions inline without even giving them a name
  // This happens a lot in Spark.
  transformInt(3, x => x * x * x);System.out.println("""res0: Int = """ + $show(res$0));$skip(32); val res$1 = 

  transformInt(10, x => x / 2);System.out.println("""res1: Int = """ + $show(res$1));$skip(50); val res$2 = 

  transformInt(2, x => { val y = x * 2; y * y });System.out.println("""res2: Int = """ + $show(res$2));$skip(408); 

  // This is really important!

  // EXERCISE
  // Strings have a built-in .toUpperCase method. For example, "foo".toUpperCase gives you back FOO.
  // Write a function that converts a string to upper-case, and use that function of a few test strings.
  // Then, do the same thing using a function literal instead of a separate, named function.

  def myToUpperCaseFunc(s: String): String = s.toUpperCase();System.out.println("""myToUpperCaseFunc: (s: String)String""");$skip(36); 
  println(myToUpperCaseFunc("abc"))}

}
