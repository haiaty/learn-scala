

val seqNumber = 0

val limit = 10

// you can user backticks ` if you want to keep the placeholder with the same
// name of the variable. In this case the placeholder after the case keyword
// have the same name of the variable defined
seqNumber match {

  case `seqNumber` if seqNumber < limit => println("lower than limit. seqNumber" + seqNumber)
  case `seqNumber` if seqNumber > limit => println("greater than limit. sqNumber" + seqNumber)
  case _ => println("hmmmm....")

}

// or you  must write the "placeholder" of the value
// in this example the "placeholder" is a and b
seqNumber match {

  case a if seqNumber < limit => println("lower than limit. seqNumber" + seqNumber)
  case b if seqNumber > limit => println("greater than limit. sqNumber" + seqNumber)
  case _ => println("hmmmm....")

}