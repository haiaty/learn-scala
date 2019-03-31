
import akka.actor.{Actor, ActorLogging, ActorSystem, Props}


/*
* When you use context.become you are changing the behavior in your actor. That means, when the actor starts it using the default receive behavior.
* When you call context.become() the behavior of the actor changes. From now on, when a messages gets sent to the actor it will execute the partial function defined in the new become instead of the receive method.
*
* *  remenber: define possibile states in the actor
* * Define the receive method in the actor to switch to the different states based on the messages it can receive.
*
* https://alvinalexander.com/scala/akka-actors-switch-between-states-with-become
*
* */
class HotSwapActor extends Actor with ActorLogging {
  import context._
  def angry: Receive = {
    case "foo" => {
      log.info("hhh")

      sender() ! "I am already angry?"
    }
    case "bar" => become(happy)
  }

  def happy: Receive = {
    case "bar" => {sender() ! "I am already happy :-)"}
    case "foo" => become(angry)
  }

  def receive = {
    case "foo" => {
      log.info("jjj")
      context.become(angry)
    }
    case "bar" => become(happy)
  }
}