package book.scalaForImpatient.unapplyMethod

object TestUnapplyMethod {
  
    def main(args: Array[String]): Unit = {
      
        val author = "Zhang San"
        // if you want to use this, you must write unapply() method in object Name
        val Name(first, last) = author  // actually calls Name.unapply(author)
        
        println(first)  // print "Zhang"
        println(last)  // print "San"
        
        println(Name.unapply(author))  // print "Some((Zhang,San))"
    
    }
}