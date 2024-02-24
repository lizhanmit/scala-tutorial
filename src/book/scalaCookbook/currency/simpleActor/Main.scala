package book.scalaCookbook.currency.simpleActor

import akka.actor.{ActorSystem, Props}

object Main extends App {

  // an actor needs an ActorSystem to get thing started
  val system = ActorSystem("HelloSystem")

  // create and start the actor
  val helloActor = system.actorOf(Props[HelloActor], name = "helloActor")

  // send the actor two messages
  helloActor ! "hello"
  helloActor ! "whatever except hello"

  system.shutdown
}
