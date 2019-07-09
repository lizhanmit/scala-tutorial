package book.scalaForImpatient.unapplyMethod

object TestUnapplySeqMethod {
  
    def main(args: Array[String]): Unit = {
      
        val author2 = "Zhao Qi Sun Li"
        
        // print "ZhaoQiSunLi"
        author2 match {
            case Name2(first, last) => println(first + last)
            case Name2(first, second, third, fourth) => println(first + second + third + fourth)
        }
    }
}