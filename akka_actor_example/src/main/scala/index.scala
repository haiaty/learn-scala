import akka.actor.ActorSystem
import akka.actor.Props



object index  {

  def main(args: Array[String]): Unit = {


    var system = ActorSystem.create("file-reader")

    val counter = system.actorOf(Props[Counter], "Counter")

    counter ! "incr"
    counter ! "incr"
    counter ! "incr"
    counter ! "get"

  }

}

