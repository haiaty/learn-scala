

/**
* ----------------------------------------------
* Case Classes
* -----------------------------------------------

  - Using the "case" modifier makes the Scala compiler add some syntactic conveniences to your class:

  1)  it adds a factory method with the name of the class: you can use NameOfClass() instead of new NameOfClass

  see:
*/

case class MyCaseClass(field1: String)


val a = MyCaseClass("Hello")




/**

2) all arguments in the parameter list of a case class implicitly get a val prefix, so they are maintained as fields

  They will print, hash, and compare a whole tree consisting of the class and (recursively) all its arguments.
  Since == in Scala always delegates to equals, this means that elements of case classes are always compared structurally

  */


case class ParamList(field1: Int)


val b = ParamList(1)

println(b.field1)




/*
*
* 3) the compiler adds "natural" implementations of methods toString, hashCode, and equalsto your class.
* */

println(b)
/*
* 4) the compiler adds a copy method to your class for making modified copies.
* if you want to change a named parameter you can do it. all fileds not modified will be copied
*
* */

val c = b.copy(field1 = 2)

println(c)