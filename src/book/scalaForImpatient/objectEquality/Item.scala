package book.scalaForImpatient.objectEquality

class Item (val desc: String, val price: Double) {
  
    final override def equals(other: Any) = 
        other match {
          case that: Item => desc == that.desc && price == that.price
          case _ => false
        }
    
    final override def hashCode = (desc, price).##
}