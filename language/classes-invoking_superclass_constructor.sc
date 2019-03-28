


class Example(aString: String) {

  def print: Unit = println(aString)
}


/**
* ----------------------------------------------
* Invoking superclass constructor
* -----------------------------------------------
  
*/
class Child(aStringOnChild: String) extends Example(aStringOnChild) {}


println(new Child("test").print)