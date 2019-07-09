package book.scalaForImpatient.traits.earlyDefinition

import book.scalaForImpatient.traits.Logger
import java.io.PrintStream

trait FileLogger extends Logger {
  
    val fileName: String
    val out = new PrintStream(fileName)
    def log(msg: String) = {
        out.println(msg)
        out.flush()
    }
}