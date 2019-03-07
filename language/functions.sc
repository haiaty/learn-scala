
/*
* ----------------------
*  complete definition
* ----------------------
*
*  - Functions are expressions that take parameters (from scala documentation)
*  but a vast number of articles on internet talks call "functions" what scala
*  documentation call "methods" (basically what is defined with "def" keyword)
*
* */



/*
* ----------------------
*  Anonimous functions
* ----------------------
*
*  On the left of => is a list of parameters.
*  On the right is an expression involving the parameters.
*
* */

//anonimous functions not assigned to any variable

//with one parameter
(x: Int) => x + 1


//with more paramerers
(name: String, age: Int) => println(name + age)

//with body in a block
(name: String, age: Int) =>  {
    println("anonimous functions with body in a block")
    println(name + age)
}

//a block with a bunch of case inside is one way of defining an anonymous function.

/*(x: Int) => {

    case (k, v) ⇒ println(k + " → " + v)
}*/
/*
* ----------------------
*  Named functions
* ----------------------
*
* */
//with no parameters
val getTheAnswer = () => 42
println(getTheAnswer())

//with one parameter
val addOne = (x: Int) => x + 1
println(addOne(1))

//Functions with multiple parameters
val add = (x: Int, y: Int) => x + y
println(add(1, 2))


//with body in a block
val test = (name: String, age: Int) =>  {
    println("named  functions with body in a block")
    println("Hello" + name + age)
}

test("mark", 3)


//
val f: String => String = { case "ping" => "pong"}
f("ping")
//f("abc")

/*
* ----------------------
*  Partial functions
* ----------------------
*
*  partial functions are only partial implementations. They do not cover every possible scenario of incoming parameters. A partial function caters to only a subset of possible data for which it has been defined
*
*  @resources: https://blog.bruchez.name/2011/10/scala-partial-functions-without-phd.html
* */
import scala.math

val squareRoot: PartialFunction[Double, Double] = {

    case d: Double if d > 0 => math.sqrt(d)

}

println(squareRoot(2.0))
//println(squareRoot(-4)) throwns scala.MatchError: -4.0 (of class java.lang.Double)

//with partial functions you can test if it is defined for certain arguments

println(squareRoot.isDefinedAt(0))


val fun: PartialFunction[List[Int], String] = {

    case Nil => "one"
    case x::y::rest => "two"
}


fun.isDefinedAt(List(1,2,3)) //true