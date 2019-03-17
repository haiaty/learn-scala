/**
* ----------------------------------------------
* Parameterless methods
* -----------------------------------------------

The recommended convention is to use a parameterless method whenever there are no parameters
and the method accesses mutable state only by reading fields of the containing object
(in particular, it does not change mutable state).

*/

//without a class

def parameterLess: Int = 1


println(parameterLess)




//within a class

class Example {

  def parameterLess: Int = 3
}



println( (new Example).parameterLess)


