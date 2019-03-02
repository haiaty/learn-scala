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