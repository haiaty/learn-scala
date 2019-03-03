
/*
* ----------------------
*  array definition 1
* ----------------------
*
* defining type and length
*
* */


val a = new Array[String](3)


/*
* ----------------------
*  array definition 2
* ----------------------
*
* types inference
*
* */

val anArrayOfStrings = Array("zero", "one")



/*
* ----------------------
*  array access
* ----------------------
* */

a(0) = "Hello"
a(1)= ","
a(2)= "World"



/*
* ----------------------
*  loop on array
* ----------------------
* */
for (i <- anArrayOfStrings)
   println(i)


/*
* ----------------------
*  loop on array (2) - functional style
* ----------------------
* */

anArrayOfStrings.foreach(item => println(item))


/*
* ----------------------
*  print array on console
* ----------------------
* */

var myArray = Array(1,2,3,4)

// way 1

println(myArray.foreach(println))

// way 2
println(myArray.deep.mkString("\n"))


/*
* ----------------------
*  map on array
* ----------------------
* */

var myArray2 = Array(1,2,3,4)

// _ is the current value of array
// here we return a random number limited to 200
// so basically it will return a new array with random numbers limited
// to 200
var newArrayAfterMap = myArray2.map(_ => scala.util.Random.nextInt(200))

println(newArrayAfterMap.deep.mkString("\n"))