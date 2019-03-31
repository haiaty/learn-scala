abstract class IntQueue {
  def get(): Int
  def put(x: Int)
}

/**
* ----------------------------------------------
*  here the trait ovverides an abstract method
  *
  *  NOTE: there is a super call to an abstract method!
  *  this is possible because Since super calls in a trait are dynamically bound, the super call in
  * trait Doubling will work so long as the trait is mixed in after another trait or class that gives a concrete definition to the method.
  * -----------------------------------------------
  *
  */
trait Doubling extends IntQueue {
  abstract override def put(x: Int) = { super.put(2 * x) }
}