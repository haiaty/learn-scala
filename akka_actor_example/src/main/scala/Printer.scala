
import akka.actor.Actor

class Printer extends Actor {

  def receive = {
    case count: Int => println("count was " + count)
  }

}
