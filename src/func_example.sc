object func_example {
  def hello(name: String): String = {
  	s"Hello, ${name}"
  }                                               //> hello: (name: String)String
  
  hello("LZ")                                     //> res0: String = Hello, LZ
  
  
  // do not need to specify the return type
  def hello2(name: String) = {
  	s"Hello, ${name}"
  }                                               //> hello2: (name: String)String
  
  
  def add(x: Int, y: Int) = x + y                 //> add: (x: Int, y: Int)Int
  
  add(1, 2)                                       //> res1: Int = 3
}