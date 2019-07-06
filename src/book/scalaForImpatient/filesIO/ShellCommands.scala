package book.scalaForImpatient.filesIO

object ShellCommands {
  
    def main(args: Array[String]): Unit = {
      
        import scala.sys.process._
        
        // there is an exception on Windows, "Exception in thread "main" java.io.IOException: Cannot run program "ls": CreateProcess error=2, The system cannot find the file specified"
        // but works well on Linux
        
        "ls -al".!  // print the result in std output
        
        val result = "ls -al".!!  // return the result as a string
        println(result)
    }
}