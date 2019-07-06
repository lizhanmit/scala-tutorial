package book.scalaForImpatient.filesIO

class Person (val name: String) extends Serializable

object SerAndDeser {
  
    def main(args: Array[String]): Unit = {
      
        val fred = new Person("Fred")
        
        import java.io._
        
        // serialization
        val out = new ObjectOutputStream(new FileOutputStream("src/book/scalaForImpatient/filesIO/person.obj"))
        out.writeObject(fred)
        out.close()
    
        // deserialization
        val in = new ObjectInputStream(new FileInputStream("src/book/scalaForImpatient/filesIO/person.obj"))
        val saveFred = in.readObject().asInstanceOf[Person]
        println(saveFred.name)  // print "Fred"
        in.close()
    }
}