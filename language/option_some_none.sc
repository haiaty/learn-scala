/**
* ----------------------------------------------
* Option, Some, None
* -----------------------------------------------

  instead of returning one object when a function succeeds and null when it fails, your function should instead return
  an instance of an Option, where the instance is either: An instance of the Scala Some class or An instance of the Scala None class

  resources:
  https://alvinalexander.com/scala/using-scala-option-some-none-idiom-function-java-null

  */

// note: the Option must have the type returned
def toInt(in: String): Option[Int] = {
  try {
    Some(Integer.parseInt(in.trim))
  } catch {
    case e: NumberFormatException => None
  }
}

//client code just need to handle the right case
toInt("hi") match {
  case Some(i) => println(i)
  case None => println("That didn't work.")
}



//
val bag = List("1", "2", "foo", "3", "bar")

// by using the Option, Some, None "way" we can do the floowing
//because of Because (a) we've written toInt to return either a Some[Int] or None value,
// and (b) flatMap knows how to handle those values, writing this line of code is a piece of cake

val sum = bag.flatMap(toInt).sum

