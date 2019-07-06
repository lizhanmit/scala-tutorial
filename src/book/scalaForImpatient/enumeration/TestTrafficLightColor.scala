package book.scalaForImpatient.enumeration

object TestTrafficLightColor {
    
  def doWhat(color: TrafficLightColor.Value) = {
      if (color == TrafficLightColor.Red) {
          "stop"
      } else if (color == TrafficLightColor.Yellow) {
          "hurry up"
      } else {
          "go"
      }
      
  }
    
  def main(args: Array[String]): Unit = {
    println(doWhat(TrafficLightColor.Red))
    
    for (c <- TrafficLightColor.values) {
        println(s"${c.id}: $c")
    }
    
    println(TrafficLightColor(0) == TrafficLightColor.Red)  // true
    
    println(TrafficLightColor.withName("Red") == TrafficLightColor.Red)  // true
  
  }
}