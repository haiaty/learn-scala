/**
* ----------------------------------------------
* Exceptions and Exceptions handling
* -----------------------------------------------

  - As with most other Scala control structures, try-catch-finally results in a value
*/


/**
* ----------------------------------------------
* throw an exception
* -----------------------------------------------

*/

//throw new Exception("Exception")

/**
* ----------------------------------------------
* Handling single exception
* -----------------------------------------------

*/

val num = 3

try {

  val test = if(num == 10) "hi" else throw new RuntimeException("num must ben ten")

} catch {
  case ex : RuntimeException => "Handled "
}

/**
* ----------------------------------------------
* Handling different cases with try catch
* -----------------------------------------------

*/

import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException
try {
  val f = new FileReader("ddd.txt")
  // Use and close file
} catch {
  case ex: FileNotFoundException => // Handle missing file
  case ex: IOException => // Handle other I/O error
}

/**
* ----------------------------------------------
* Catch all Exceptions
* -----------------------------------------------

*/

val testWithDefault = 3

try {


  val testWithDefaultResult = if(testWithDefault == 10) "hi" else throw new RuntimeException("num must ben ten")

} catch {
  case _: Throwable => "Default handled"
}

//or
// All the safe exceptions are matched by scala.util.control.NonFatal
import scala.util.control.NonFatal
try {

  throw new Exception

}
catch { case NonFatal(t) => "handled"}

/**
* ----------------------------------------------
* Finally
* -----------------------------------------------

  - Usually finally clauses do some kind of clean up, such as closing a file. Normally, they should not change the value computed in the main body or a catch clause of the try.
  - it's usually best to avoid returning values from finally clauses

*/

try {

  throw new Exception

} finally {
  println("code executed even in case of exception")
}

// if a finally clause includes an explicit return statement, or throws an exception, that return value or exception will "overrule" any previous one that originated in the try block or one of its catch clauses
def f(): Int = try return 1 finally return 2 // return 2
f()

def g(): Int = try 1 finally 2 //return 1 because finally not has the return keyword
g()