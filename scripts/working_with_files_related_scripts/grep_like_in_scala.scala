
/**
  * ------------------------------------------------------
  * Performs a search inside every file for a given string
  * -----------------------------------------------------
  *
  * */

/**
  *
  * @param file
  * @return
  */
def fileLines(file: java.io.File) =
  //read every line of a file
  scala.io.Source.fromFile(file).getLines().toList


def grep(pattern: String): Unit = {
  val filesHere = (new java.io.File(".")).listFiles
  for (
    file <- filesHere
    if file.getName.endsWith(".scala");
    line <- fileLines(file)
    if line.trim.matches(pattern)
  ) println(file + ": " + line.trim)
}

grep(".*gcd.*")
