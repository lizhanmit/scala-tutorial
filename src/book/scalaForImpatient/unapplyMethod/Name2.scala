package book.scalaForImpatient.unapplyMethod

object Name2 {
  
    def unapplySeq(input: String) = {
        if (input.trim() == "") {
            None
        } else {
            Some(input.trim().split("\\s+"))
        }
    }
}