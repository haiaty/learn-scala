

/**
* ----------------------------------------------
* simple example
* -----------------------------------------------
  - The for  in the above code is actually a method call to the the foreach method of the nums object (that is an instance of scala.Seq) passing the body of the for loop as a closure in the foreach method. The code inside the for loop is actually the apply(..) method of the closure (a scala.Function1 in our case).
*/
//the "i <- 1 to 4" syntax is called a generator
for (i <- 1 to 4)
  println("Iteration " + i)




//If you don't want to include the upper bound of the range in the values that are iterated over, use until instead of to

for (i <- 1 until 4)
  println("Iteration " + i)


/*
* Using filter with if on for loop
*
* */
for (i <- 1 until 4 if i == 2) //print Iteration 2
  println("Iteration " + i)


//using more than one filter (they are in and and not in or)
for (i <- 1 until 4
     if i == 2
     if i == 1
) println("Iteration " + i)


//Mid-stream assignment in a for expression

for {i <- 1 until 4
     if i == 2
     a = 3
} println("Mid stream assignment " + a) // 3

/**
  * ------------------------------------
  * using yield to produce a new collection
  * -------------------------------------
  * // - The type of the resulting collection is based on the kind of collections processed in the iteration clauses
  * // - The yield goes before the entire body. Even if the body is a block surrounded by curly braces, put
  * //  the yield before the first curly brace, not before the last expression of the block.
  */
var newCol = for {i <- 1 until 4
} yield {i + "a"}

/**
  * ----------------------------------------------
  * for
  * -----------------------------------------------
  *
  * thrnsform to upper case nmes starting with 'b'
  */
case class Person(firstName: String, lastName: String)

val people = List(
  Person("barney", "rubble"),
  Person("fred", "flintstone")
)

val namesStartingWithB = for {
  p <- people                  // generator
  fname = p.firstName          // definition
  if (fname startsWith "b")    // filter
} yield fname.toUpperCase

namesStartingWithB.foreach(println)