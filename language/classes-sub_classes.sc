
/**
* ----------------------------------------------
* extends keyword
* -----------------------------------------------

   - subclasses inherit all non-private members. private members of the superclass are not inherited in a subclass
  - a member of a superclass is not inherited if a member with the same name and parameters is already implemented in the subclass. In that case we say the member of the subclass overrides the member of the superclass
  - If you leave out an extends clause, the Scala compiler implicitly assumes your class extends from scala.AnyRef

*/
class Animal {}

class Duck extends Animal {}

//Subtyping means that a value of the subclass can be used wherever a value of the superclass is required


val animal : Animal = new Duck


/**
* ----------------------------------------------
* override methods
* -----------------------------------------------
  - in order to override we must use the key 'override'
  - note that you can override a parameterless method with a val

*/

class OverrideExample {

  def methodA = {println("methodA")}

  def parameterLessMethod : Int = 2
}

class SubClassOverrideExample extends OverrideExample {

  override def methodA: Unit = println("override methodA")

  override val parameterLessMethod : Int = 3

}

println((new OverrideExample).parameterLessMethod)
println((new SubClassOverrideExample).parameterLessMethod)