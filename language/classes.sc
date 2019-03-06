// Classes in Scala cannot have static members.

/*
* ----------------------
*  class with fields and methods
* ----------------------
* -
*/
// any code you place in the class body will be compiled when class
// are instatiated

class ExampleClassWithFields(n: Int, d: Int){

  val field1 = n

  val field2 = d

  private val field3 = "private"

  def sum(): Int = {
    field1 + field2
    //is the same as:
    //this.field1 + this.field2
  }

  private def privateMethod(): Unit = {
    println("private method")
  }

}

var x = new ExampleClassWithFields(1,2)

println(x.field1, x.field2, x.sum())

/*
* ----------------------
*  initialization with class parameters
* ----------------------
*
*  if a class doesn't have a body, you don't need to specify empty curly braces (though you could, of course, if you wanted to)
*
* - name and age are called class parameters. The Scala compiler will gather up these two class parameters and create a primary constructor that takes the same two parameters.
* */

class ExampleWithClassParameters(name: String, num: Int)

println(new ExampleWithClassParameters("hello", 1))

/*
* ----------------------
*  class with body
* ----------------------
*
*/
// any code you place in the class body will be compiled when class
// are instatiated

class ExampleWithBody {

  println("Instatinated Example2")
}

println(new ExampleWithBody)


/*
* ----------------------
*  override toString
* ----------------------
*
*/

class ExampleOverrideToString(n: Int, d: Int) {
  override def toString = n +"/"+ d
}

println(new ExampleOverrideToString(2,3))

/*
* ----------------------
*  Preconditions using require
* ----------------------
*
* A precondition is a constraint on values passed into a method or constructor, a requirement which callers must fulfill
*
*  - The require method takes one boolean parameter
*/

class ExamplePreconditionRequire(n: Int){
  require(n > 3)
}

println(new ExamplePreconditionRequire(5))

//when precondition is not respected a
// java.lang.IllegalArgumentException: requirement failed
// will be raised

//println(new ExamplePreconditionRequire(2)) //throws java.lang.IllegalArgumentException


/*
* ----------------------
*  Auxiliary constructors
* ----------------------
*
// constructors other than the primary constructor are called auxiliary constructors.

// - Auxiliary constructors in Scala start with def this(...)
// - every auxiliary constructor must invoke another constructor of the same class as its first action. it can be the primary constructor or another auxiliary constructor that comes textually before the calling constructor
*/


class ExampleAuxiliaryConstructor(n: Int, d: Int){


  def this(n: Int) = this(n, 1) // auxiliary constructor

}

println(new ExampleAuxiliaryConstructor(3, 2))
println(new ExampleAuxiliaryConstructor(3))


/*
* ----------------------
*  Method overloading
* ----------------------
*
*/

class ExampleMethodOverloading {

  def customMethod(x: Int): Unit = println(x)

  def customMethod(x: String): Unit = println(x)
}

println((new ExampleMethodOverloading).customMethod(1))
println(new ExampleMethodOverloading customMethod "Hi")


/*
* ----------------------
*  Functional Objects
* ----------------------
*
* objects that do not have any mutable state
*/

class Rational(n: Int, d: Int) {

  val numer: Int = n
  val denom: Int = d

  override def toString = numer +"/"+ denom

  //methods always return new Object
  def add(that: Rational): Rational =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )

  def * (that: Rational): Rational =
    new Rational(numer * that.numer, denom * that.denom)
}