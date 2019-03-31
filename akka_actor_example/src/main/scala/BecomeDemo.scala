import akka.actor._

class MyActor extends Actor {

  override def receive: Receive = {
    println("Happens here")
    active(Set.empty)
  }

  def active(isInSet: Set[String]): Receive = {
    case Add(key) =>
      context.become(active(isInSet+key))
    case Contains(key) =>
      sender() ! isInSet(key)
    case ShowAll =>
      println(isInSet.toSeq)
  }

}

case class Add(key: String)
case class Contains(key: String)
object ShowAll


object DemoBecome extends App{

  override def main(args: Array[String]): Unit = {

    val system = ActorSystem("BecomeUnbecome")
    val act = system.actorOf(Props(classOf[MyActor]), "demoActor")


    act ! ShowAll
    act ! Add("1")
    act ! ShowAll
    act ! Contains("1")
   // act ! Add("2")
    //act ! ShowAll

    Thread.sleep(10000)
    System.exit(0)

  }
}