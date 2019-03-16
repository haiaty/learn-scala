
/*
* ----------------------
*  complete definition
* ----------------------
*
*  methods starts with the "def" keyword (from scala documentation)
*  but on internet a lot of articles call them functions
*
* */


//with return keyword
def sum(a:Int, b:Int):Int = {
  return  a + b
}


println(sum(1,2))

/*
* ----------------------
*  without return keyword
* ----------------------
* */

def sum2(a:Int, b:Int):Int = {
  a + b
}


println(sum2(1,2))



/*
* ----------------------
*  one line
*
*  when you have a single instruction that will be returned
* ----------------------
* */

def sum3(a:Int, b:Int):Int = a + b


println(sum3(1,2))


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


/**
* ----------------------------------------------
* you can use curly braces if method has only one parameter
* -----------------------------------------------
 In any method invocation in Scala in which you're passing in exactly one argument, you can opt to use curly braces to surround the argument instead of parentheses.
*/

def oneParam(x: Int) = println(x)

oneParam { 2 }


/**
* ----------------------------------------------
* By name param
* -----------------------------------------------
By-name parameters exist precisely so that you can do this. To make a by-name parameter, you give the parameter a type starting with => instead of () =>.

*/

def byNameParam(predicate: => Boolean) =
  if (assertionsEnabled && !predicate)
    throw new AssertionError

