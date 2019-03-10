
/*
* ----------------------
*  Functions
* ----------------------
*
*  - Functions are expressions that take parameters (from scala documentation)
*  but a vast number of articles on internet talks call "functions" what scala
*  documentation call "methods" (basically what is defined with "def" keyword)
*
* */

/**
* ----------------------------------------------
* functions defintions
* -----------------------------------------------

*/

// full
def myFunc(x: Int) : Int = {
    x +1
}

myFunc(1)

//if you want you can omit the return value
def myFuncWithoutReturn(x: Int) = {
    x +1
}

myFuncWithoutReturn(1)

// if you return only an expression you can leave the curly braces
def myFuncWithoutBraces(x: Int): Int = x +1

myFuncWithoutBraces(1)



/*
* ----------------------
*  function literals as function values  -> Anonimous functions
* ----------------------
* A function literal is compiled into a class that when instantiated at runtime is a function value.[2] Thus the distinction between function literals and values is that function literals exist in the source code, whereas function values exist as objects at runtime.
*
* Function values are function that can be passed around
* as params to other functions
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
*   Function values -> Named functions
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

/**
* ----------------------------------------------
*  short forms of function literals
* -----------------------------------------------

*/

//One way to make a function literal more brief is to leave off the parameter types

var someNums = List(1,2)

//the type of param can be omit because scala do a target typing, basically since you are using that literal function on a list of integer it infers that the value of x is a Int
// NOTE: if the compiler can't infer, you must specify the type
someNums.filter(x => x > 0 )

// PLACEHOLDER SYNTAX
// you can use underscores as placeholders for one or more parameters, so long as each parameter appears only one time within the function literal.

someNums.filter(_ > 0)

//Note that _ + _ expands into a literal for a function that takes two parameters. This is why you can use this short form only if each parameter appears in the function literal exactly once. Multiple underscores mean multiple parameters, not reuse of a single parameter repeatedly. The first underscore represents the first parameter, the second underscore the second parameter, the third underscore the third parameter, and so on.
val fzz = (_: Int) + (_: Int) //literal function that sums two params with placeholder
fzz(5, 10)

/**
* ----------------------------------------------
* Partially applied functions
* -----------------------------------------------

  A partially applied function is an expression in which you don't supply all of the arguments needed by the function
  Instead, you supply some, or none, of the needed arguments
 - you can also replace an entire parameter list with an underscore
*/

//the underscore in this case is not a placeholder for a single parameter. It is a placeholder for an entire parameter list
//NOTE: Remember that you need to leave a space between the function name and the underscore; otherwise, the compiler will think you are referring to a different symbol,
someNums.foreach(println _) //the same as  someNumbers.foreach(x => println(x))


def sum(a: Int, b: Int, c: Int) = a+b+c

val aPartiallyAppliedFunc = sum(1, _: Int, 3)

aPartiallyAppliedFunc(1) //gives 5



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


/**
* ----------------------------------------------
* Local functions
* -----------------------------------------------

*/


object LongLines {

    //methof
    def process(filename: String, width: Int) = {

        //local function inside the method
        def processLocal(line: String) = {
            if (line.length > width)
                println(filename + ": " + line.trim)
        }


        processLocal(filename)
    }
}

/**
* ----------------------------------------------
* Closures
* -----------------------------------------------

*/


var someVar = 1

var aClosure = (x: Int) => x + someVar //a closure "captures" the vars on the scope

println(aClosure(1)) // 2

//but if you change the var "someVar" also the captured one will be changed as well

someVar = 2

println(aClosure(1)) // 3


/**
* ----------------------------------------------
*  repeated params
* -----------------------------------------------
Scala allows you to indicate that the last parameter to a function may be repeated.
*/

def echo(args: String*) =
    for (arg <- args) println(arg) //Inside the function, the type of the repeated parameter is an Array of the declared type of the parameter

echo("Hello")
echo("hello", "world")


/**
* ----------------------------------------------
* named arguments
* -----------------------------------------------

  //Called with named arguments, the arguments can be reversed without changing the meaning
*/

def aFunc(name: String, age: Int) = println("Name" + name + "age" + age)

aFunc(age = 20,  name = "test")


/**
* ----------------------------------------------
* Default parameter value
* -----------------------------------------------

*/

def anotherFunc(x: Int = 2) = println(x)

anotherFunc()

/**
* ----------------------------------------------
* function that accepts generic type
* -----------------------------------------------

*/

def funcOnGenericType[A](param1: A) = println(param1)

funcOnGenericType(1)
funcOnGenericType("hello")