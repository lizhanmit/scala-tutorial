package book.scalaForImpatient.traits.earlyDefinition

import book.scalaForImpatient.traits.SavingAccount

object TestEarlyDefinition {
  
    def main(args: Array[String]): Unit = {
      
        /*
        val acct = new SavingAccount with FileLogger {
            val fileName = "myApp.log"
        }
        
        acct.log("this is log")  // NullPointerException, because fileName is used in constructor of FileLogger before its initialization above
        */
        
        
        /*
         * solution: early definition
         * define fileName before superclass or trait constructor, namely FileLogger here
         */
        val acct = new {val fileName = "src/book/scalaForImpatient/traits/earlyDefinition/myApp.log"} with SavingAccount with FileLogger
        acct.log("this is log")  // there will be "this is log" in myApp.log file
        
    }
}