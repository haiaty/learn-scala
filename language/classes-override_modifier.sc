/**
* ----------------------------------------------
* Override modifiers
* -----------------------------------------------

  it is required for all members that override a concrete member in a parent class.
*/

class Example {
  def greet: Unit = println("Hello")
}


class Child extends Example {
  override def greet: Unit = println("Hi")
}


println(new Example greet)
println(new Child greet)

/**
* ----------------------------------------------
* The modifier is optional if a member implements an abstract member with the same name.
* -----------------------------------------------

*/

abstract class AbstractExample {
  def abstractMethod: Unit
}


class ChildAbstract extends AbstractExample {
  def abstractMethod: Unit = { println("hi")}
}


println(new ChildAbstract abstractMethod)
