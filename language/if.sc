

// - Scala's if is an expression that results in a value

/*
* ----------------------
*  Imperative style
* ----------------------
* */


val args = List("test.txt")

var filename = "default.txt"
if (!args.isEmpty)
  filename = args(0)

println(filename)


/*
* ----------------------
*  if returning a value
* ----------------------
*
* avantages here: advantage is that it uses a val instead of a var.
*  It tells readers of the code that the variable will never change, saving them from scanning all code in the variable's scope to see if it ever changes.
* */
val filenam =
  if (!args.isEmpty) args(0)
  else "default.txt"

println(filenam)



//one line
println(if (!args.isEmpty) args(0) else "default.txt")