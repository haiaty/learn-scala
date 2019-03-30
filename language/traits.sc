
/**
* ----------------------------------------------
* traits
* -----------------------------------------------

  -A trait encapsulates method and field definitions, which can then be reused by mixing them into classes
  - a class can mix in any number of traits
  -  they are useful: widening thin interfaces to rich ones, and defining stackable modifications

  - Once a trait is defined, it can be mixed in to a class using either the extends or with keywords

*/


//it has the default superclass of AnyRef
trait aTraitExample {

  def methodToBeReused = println("to be reused")
}



class A extends aTraitExample {}

val obj = new A

obj.methodToBeReused
/**
* ----------------------------------------------
* A trait also defines a type.
* -----------------------------------------------

*/

val aVar: aTraitExample = obj
aVar.methodToBeReused