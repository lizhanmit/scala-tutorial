object func_example {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(84); 
  def hello(name: String): String = {
  	s"Hello, ${name}"
  };System.out.println("""hello: (name: String)String""");$skip(17); val res$0 = 
  
  hello("LZ");System.out.println("""res0: String = """ + $show(res$0));$skip(106); 
  
  
  // do not need to specify the return type
  def hello2(name: String) = {
  	s"Hello, ${name}"
  };System.out.println("""hello2: (name: String)String""");$skip(40); 
  
  
  def add(x: Int, y: Int) = x + y;System.out.println("""add: (x: Int, y: Int)Int""");$skip(15); val res$1 = 
  
  add(1, 2);System.out.println("""res1: Int = """ + $show(res$1))}
}
