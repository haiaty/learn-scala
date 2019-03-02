

val s = "Hello, world!"

/**
  *
  *  In Scala, you can leave off empty parentheses on method calls. The convention is that you include parentheses
  *  if the method has side effects, such as println(), but you can leave them off if the method has no side effects,
  *  such as toLowerCase invoked on a String:
  * */


s.toLowerCase


/**
  * In this latter case of a method that requires no arguments,
  * you can alternatively leave off the dot and use postfix operator notation
  */

s toLowerCase