


val filesHere = (new java.io.File(".")).listFiles

for (file <- filesHere)
  println(file)

// using filter on for

print("#######")

for (file <- filesHere if file.getName.endsWith(".php"))
  println(file)