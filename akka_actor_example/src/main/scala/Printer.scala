
import akka.actor.{Actor, ActorLogging, Props}


class Printer extends Actor  with ActorLogging {

  def receive = {
    case count: Int => println("count was " + count)
    case "using_become" => {
      log.info("ok")
      val a = context.actorOf(Props[HotSwapActor], "testHotSwapper")
      a ! "foo"
      a ! "foo"
    }
    case "I am already angry?" => println("I am already angry?")
  }

}
