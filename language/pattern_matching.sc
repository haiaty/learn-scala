/**
* ----------------------------------------------
* Match expressions
* -----------------------------------------------

   - match expressions result in a value

  A pattern match includes a sequence of alternatives, each starting with the keyword case.
  Each alternative includes a pattern and one or more expressions, which will be evaluated if the pattern matches. An arrow symbol => separates the pattern from the expressions.
*/

var x = "Hello"


x match {
  case "Hi" => println(x)
  case "Hello" => println("say" + x )
}


// case with placeholder
x = "Hi all"

x match {
  case "Hi" => println(x)
  case "Hello" => println("say" + x )
  case _ => println("placeholder to match unknow")
}

/**
* ----------------------------------------------
*  A match expression that yields a value.
* -----------------------------------------------
- store matched value in a variable
*/
var a = 1

val b = a match {
  case 1 => "hi"
  case 2 => "hello"
  case _ => "something"
}

println(b)