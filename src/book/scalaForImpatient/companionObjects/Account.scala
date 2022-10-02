package book.scalaForImpatient.companionObjects

class Account {
  val id = Account.newUniqueNumber()
  private var balance = 0.0
  def deposit(amount: Double) = {
      balance += amount
  }
}

// methods or fields in the object are static
object Account {
    private var lastNumber = 0
    private def newUniqueNumber() = {
        lastNumber += 1
    }
}