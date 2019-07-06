package book.scalaForImpatient.filesIO

import java.io.PrintWriter

object WriteFiles {
  
    def main(args: Array[String]): Unit = {
      
        val out = new PrintWriter("src/book/scalaForImpatient/filesIO/number.txt")
        
        for (i <- 1 to 10) {
            out.println(i)
        }
        
        out.close()
    }
}