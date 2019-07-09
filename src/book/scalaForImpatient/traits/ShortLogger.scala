package book.scalaForImpatient.traits

trait ShortLogger extends ConsoleLogger {
  
    val maxLength: Int  // abstract field
    
    override def log(msg: String) = super.log(
        if (msg.length() < maxLength) {
            msg
        } else {
            s"${msg.substring(0, maxLength - 3)}..."
        }
    )
}