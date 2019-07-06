package book.scalaForImpatient.filesIO

import scala.io.Source

object ReadFiles {
  
    def main(args: Array[String]): Unit = {
      
        // here, use def because you use source more than once later, you need to evaluate it every time when you use it
        // if you use val, source will not be evaluated later and you will get errors
        def source = Source.fromFile("src/book/scalaForImpatient/filesIO/myFile.txt")
       
        /*
         * read lines
         */
        println("=== read lines ===")
        val lineIterator = source.getLines()
        
        for (line <- lineIterator) {
            println(line)
        }
        
        val lines = source.getLines().toArray
        println(lines(1))  // print "this is line 2"
        
        val contents = source.mkString
        println(contents)
        
        
        /*
         * read characters
         */
        println("=== read characters ===")
        for (c <- source) {
            println(c)
        }
        
        println("=== read characters - peek ===")
        // peek without consuming
        val iter = source.buffered
        while (iter.hasNext) {
            println(iter.next)
        }
        
        
        /*
         * read tokens
         */
        println("=== read tokens ===")
        // split based on space
        val tokens = source.mkString.split("\\s+")
        println(tokens(1))  // print "is" 
        
        
        // do not forget to close the source 
        source.close()
        
        
        /*
         * read from URLs
         */
        println("=== read URLs ===")
        // read the html of the web page
        val urlSource = Source.fromURL("http://horstmann.com", "UTF-8")
        
        urlSource.close()
    }
}