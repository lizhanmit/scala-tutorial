package book.scalaForImpatient.typeChecksAndCasts

class Employee extends Person {
  
    var salary = 0.0
    
    override def toString = s"${super.toString}[salary=$salary]"
}