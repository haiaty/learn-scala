/*
* -----------------
* Operators
* ----------------
*
*
* - operators are actually just a nice syntax for ordinary method calls.
* For example, 1 + 2 really means the same thing as (1).+(2)

Any method can be an operator. In Scala operators are not special language syntax: any method can be an operator. What makes a method
an operator is how you use it. When you write "s.indexOf('o')", indexOf is not an operator. But when you write "s indexOf 'o'", indexOf is an operator,
because you're using it in operator notation.

*
* */

/*
* -----------------
*  Infix Operators
* ----------------
*
**/

val sum = 1 + 2

// In other words, class Int contains a method named + that takes an Int and returns an Int result.
// This + method is invoked when you add two Ints:
// is same as:

val sumMore = (1).+(2)


/*
* -----------------
* You can use any method in operator notation
* ----------------
You can use any method in operator notation.For example, class String has a method,
indexOf, that takes one Char parameter.
 */

val s = "Hello, world!"

s indexOf 'o'

// is the same as

s.indexOf('o')



/*
 -----------------
* Operator notation using multiple arguments
* ----------------
But whenever you call a method that takes multiple arguments using operator notation,
you have to place those arguments in parentheses.
*/

s indexOf ('o', 5)


/*
*
* -----------------
  Prefix Operators
* ----------------
*
* - you put the method name before the object on which you are invoking the method, for example, the `-' in -7
  - take only one operand
  - other examples of prefix operators: !found and  ~0xFF
***/

val x = -7

// is the same of:
var xy = (7).unary_-


/*
*
* ------------------------------
  Custom prefix operator on class
  -----------------------------

  here in the class we define the custom prefix operator !
  in order to use as prefix operator

  keep in mind that you can use only these +, -, !, and ~ as prefix
  so if you try to def unary_* you can't use it in the prefix form
*/
class A {

  def unary_! = { println("called in prefix form")}

  def unary_* = {println("called unary_*")}
}

//you can do that
!(new A)

//you can't do that
//*(new A)

//you can do that
(new A).unary_*

/*
*
* -----------------
  Postfix Operators
* ----------------
*
- you put the method after the object, for example, the "toLong" in "7 toLong".
- take only one operand
**/
 var y = 7 toLong
