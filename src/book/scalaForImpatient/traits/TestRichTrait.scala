package book.scalaForImpatient.traits

object TestRichTrait {
  
    def main(args: Array[String]): Unit = {
      
        val acct = new SavingAccount with Logger {
            override def log(msg: String) = {
                println(s"Log from SavingAccount: $msg")
            }
        }
        
        acct.info("this is info")
        acct.warn("this is warn")
        acct.severe("this is severe")
        
    }
}