


/**
* ----------------------------------------------
* final menber
* -----------------------------------------------

*/


class Example {

  final def greet = println("hi")
}


// YOU CAN'T OVERRIDE MEMBER WHEN FINAL IS DEFINED
class Child extends Example {
  override def greet = println("hello") //causes error
}


/**
* ----------------------------------------------
*  final class
* -----------------------------------------------

*/

final class ExampleFinal {}

class CantExtendFinal extends ExampleFinal {}