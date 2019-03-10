
/**
* ----------------------------------------------
* Scope curly braces
* -----------------------------------------------

   The most common example of scoping is that curly braces generally introduce a newscope,
   so anything defined inside curly braces leaves scope after the final closing brace

*/

var x = {
  val i = 0

  while(i < 10) {
    val j = 1
  }

  println(j) //j is out of scope
}



/**
* ----------------------------------------------
* same variable name inner scope
* -----------------------------------------------

   Keep in mind that such code can be very confusing to readers,
   because variable names adopt new meanings in nested scopes. It is usually better to choose a new, meaningful variable name rather than to shadow an outer variable.

*/

val a = 1

{
  val a = 2 // Compiles just fine
  println(a)
} //print 2
println(a) //print 1