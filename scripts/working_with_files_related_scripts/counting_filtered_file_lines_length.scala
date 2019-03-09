

def fileLines(file: java.io.File) =
  scala.io.Source.fromFile(file).getLines().toList


val filesHere = (new java.io.File(".")).listFiles


val lineLengths = for { file <- filesHere
      if file.getName.endsWith(".scala")
      line <- fileLines(file)
      trimmed = line.trim
      if trimmed.matches(".*io.*")
} yield trimmed.length

println(lineLengths)