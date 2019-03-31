import akka.actor.{AbstractActor, Actor, ActorSystem, Props}




/*
* When you use context.become you are changing the behavior in your actor. That means, when the actor starts it using the default receive behavior.
* When you call context.become() the behavior of the actor changes. From now on, when a messages gets sent to the actor it will execute the partial function defined in the new become instead of the receive method.
*
*
*
* */
object using_become  {

  def main(args: Array[String]): Unit = {


    var system = ActorSystem.create("testing-becomer")

    val testBecome = system.actorOf(Props[Printer], "printer")

    testBecome ! "using_become"


    system.terminate()

  }
}

