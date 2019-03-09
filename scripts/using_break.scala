
/**
* ----------------------------------------------
* If you need to use the "break" control
* -----------------------------------------------

  use break, there's help in Scala's standard library. Class Breaks in package scala.util.control offers a break method,
  which can be used to exit an enclosing block that's marked with breakable.
*/

import scala.util.control.Breaks._
import java.io._


val in = new BufferedReader(new InputStreamReader(System.in))
breakable {
  while (true) {
    println("? ")
    if (in.readLine() == "") break
  }
}
