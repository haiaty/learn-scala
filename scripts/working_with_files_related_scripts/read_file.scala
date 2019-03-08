
/**
  * usage example:  scala read_file ./test.txt
  */

import scala.io.Source


if (args.length > 0) {

  for (line <- Source.fromFile(args(0)).getLines)
    println(line)

}