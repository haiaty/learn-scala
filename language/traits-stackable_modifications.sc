/**
* ----------------------------------------------
* traits used as stackable modifications
* -----------------------------------------------

  REMENBER:  * When you call a method on a class with mixins, the method in the trait furthest to the right is called first. If that method calls super,
  * it invokes the method in the next trait to its left, and so on.


  It’s important to note that the different states can only receive the messages they’re programmed for, and those messages can be different in the different states.

  */

abstract class IntQueue {
  def get(): Int
  def put(x: Int)
}

import scala.collection.mutable.ArrayBuffer
class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]
  def get() = buf.remove(0)
  def put(x: Int) = { buf += x }
}

trait Doubling extends IntQueue {
  abstract override def put(x: Int) = { super.put(2 * x) }
}

trait Incrementing extends IntQueue {
  abstract override def put(x: Int) = { super.put(x + 1) }
}
trait Filtering extends IntQueue {
  abstract override def put(x: Int) = {
    if (x >= 0) super.put(x)
  }
}


val queue = (new BasicIntQueue
  with Incrementing with Filtering)

queue.put(-1)
queue.put(0)
queue.put(1)
queue.get()


// different order so rules are applied fr

val queue2 = (new BasicIntQueue
  with Filtering with Incrementing)


queue2.put(-1)
queue2.put(0)
queue2.put(1)
queue2.get()