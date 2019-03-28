/**
* ----------------------------------------------
*  Value class
* -----------------------------------------------

  To define a value class, make it a subclass of AnyVal

*/

class AValueClass(val field: Int) extends AnyVal {}


new AValueClass(3)