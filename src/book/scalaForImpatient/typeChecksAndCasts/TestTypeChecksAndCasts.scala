package book.scalaForImpatient.typeChecksAndCasts

object TestTypeChecksAndCasts {
    
  def main(args: Array[String]): Unit = {
      val person = new Employee
      
      if (person.isInstanceOf[Employee]) {
          val employee = person.asInstanceOf[Employee]
          println(employee.toString())
      }
      
      // or
      // better
      person match {
        case e: Employee => {val employee = person.asInstanceOf[Employee]; println(employee.toString())}
        case _ => println("does not match")
      }
  }
}