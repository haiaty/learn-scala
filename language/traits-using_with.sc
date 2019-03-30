/**
* ----------------------------------------------
*  using with
* -----------------------------------------------


  If you wish to mix a trait into a class that explicitly extends a superclass, you use extends to indicate the superclass and with to mix in the trait
*/

trait aTraitExample {

  def methodToBeReused = println("to be reused")
}

trait anotherTrait

class Parent {}

class Children extends Parent with aTraitExample {}


val aVar = new Children

aVar.methodToBeReused


/**
* ----------------------------------------------
* multiple traits with 'with'
* -----------------------------------------------

*/

class ChildrenB extends Parent with aTraitExample with anotherTrait {}