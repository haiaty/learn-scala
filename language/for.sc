
//the "i <- 1 to 4" syntax is called a generator
for (i <- 1 to 4)
  println("Iteration " + i)




//If you don't want to include the upper bound of the range in the values that are iterated over, use until instead of to

for (i <- 1 until 4)
  println("Iteration " + i)