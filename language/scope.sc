
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



