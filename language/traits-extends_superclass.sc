


abstract class A {}



/**
* ----------------------------------------------
*
* -----------------------------------------------

*/

//This declaration means that the trait
// can only be mixed into a class that also extends A
trait anExample extends A {}

class ChildA extends A with anExample {} //ok


/* cant do this class ChildB extends anExample {}*/


