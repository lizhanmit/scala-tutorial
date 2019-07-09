package book.scalaForImpatient.traits

trait TimestampLogger extends ConsoleLogger {
  
   override def log(msg: String) = super.log(s"${java.time.Instant.now()} $msg")
}