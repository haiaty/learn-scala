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
  *
  * traits further to the right take effect first.
  *
  * When you call a method on a class with mixins, the method in the trait furthest to the right is called first. If that method calls super,
  * it invokes the method in the next trait to its left, and so on.
* -----------------------------------------------

*/

class ChildrenB extends Parent with aTraitExample with anotherTrait {}