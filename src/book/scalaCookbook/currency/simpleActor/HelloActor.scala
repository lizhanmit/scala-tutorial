package book.scalaCookbook.currency.simpleActor

import akka.actor.Actor

class HelloActor extends Actor {

  override def receive = {
    case "hello" => println("hello back at you")
    case _ => println("huh?")
  }

}