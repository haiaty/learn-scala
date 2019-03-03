import scala.collection.mutable.ListBuffer

/**
  * LIST BUFFER
  *
  * a ListBuffer is resizable similar to an ArrayBuffer, except that it uses a Linked List as its internal data structure.
  *
  *
  * resources:
  * https://www.scala-lang.org/api/current/scala/collection/mutable/ListBuffer.html
  * */


/*
* ----------------------
*  initialization
* ----------------------
* */

var aListBuffer = new ListBuffer[Int]


//with values

var aListBufferInitializedWithValues = ListBuffer("hello", "world")

/*
* ----------------------
*  access elements at specific index
* ----------------------
* */


aListBufferInitializedWithValues(0)


/*
* ----------------------
*  adds elements to a ListBuffer using +=
* ----------------------
* */

var another = new ListBuffer[String]

another += "Hello"
another += "World"



/*
* ----------------------
*  remove elements to a ListBuffer using -=
* ----------------------
* */

var listBuffer2 = ListBuffer(1,3,4)

listBuffer2 -= 3

println(listBuffer2)