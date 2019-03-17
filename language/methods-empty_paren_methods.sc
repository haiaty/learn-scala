/**
* ----------------------------------------------
* Empty paren methods
* -----------------------------------------------
  *
  * mthod with empty params
  *
  *
  *

*/

def height(): Int = 4

height()


//You can also leave off the empty parentheses on an invocation of any function that takes no arguments


height


//However, it's still recommended to write the empty parentheses when the invoked method represents more than a property of its receiver object. For instance, empty parentheses are appropriate if the method performs I/O, writes reassignable variables (vars), or reads vars other than the receiver's fields, either directly or indirectly by using mutable objects.
// you should never define a method that has side-effects without parentheses