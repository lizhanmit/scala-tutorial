package book.scalaForImpatient.unapplyMethod

object Name {
  
    def unapply(input: String) = {
        val pos = input.indexOf(" ")
        if (pos == -1) {
            None
        } else {
            Some((input.substring(0, pos), input.substring(pos + 1)))
        }
    }
}