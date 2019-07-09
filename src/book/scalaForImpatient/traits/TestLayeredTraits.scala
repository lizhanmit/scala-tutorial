package book.scalaForImpatient.traits

/**
 * "Back to front" rule:
 * If a class or an object extends multiple traits, when the obj of this class 
 * invokes super.<method>, it first invokes the method of the last trait, 
 * finally invokes the first trait.
 */
object TestLayeredTraits {
  
    def main(args: Array[String]): Unit = {
      
        // "back to front" rule
        val acct1 = new SavingAccount with TimestampLogger with ShortLogger {
            val maxLength = 15  // must override abstract field
        }
        val acct2 = new SavingAccount with ShortLogger with TimestampLogger {
            val maxLength = 15
        }
        
        // first invokes log() in ShortLogger, then TimestampLogger
        // print "2019-07-07T03:36:03.403Z This is a sa..."
        acct1.log("This is a sample log message.")  
        
        // first invokes log() in TimestampLogger, then ShortLogger
        // print "2019-07-07T0..."
        acct2.log("This is a sample log message.") 
    }
}