/**
* ----------------------------------------------
* parametric fields on constructor
* -----------------------------------------------
  in
*/

// you can do this:

class Example(val someField: String) {}


println((new Example("SomeString").someField))

//in order to avoid this redundancy:


class RedundantParameterDefinition(someField: String) {

  val field: String = someField

}


/**
* ----------------------------------------------
* it is possible to add modifiers, such as private, protected or override to these parametric fields,
* -----------------------------------------------

*/

class Cat {
  val dangerous = false
}
class Tiger(
             override val dangerous: Boolean,
             private var age: Int
           ) extends Cat