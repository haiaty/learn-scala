
/***

  Filter a given list of integers and output only those values that are less than a specified value .
  The output integers should be in the same sequence as they were in the input.
   You need to write a function with the recommended method signature for the languages mentioned below.
   For the rest of the languages, you have to write a complete code.

  exercise from Hackerrank.com

  */


/**
  *
  * @param delim the delimiter
  * @param arr the list of integers
  * @return
  */
def filter(delim: Int, arr: List[Int]): List[Int] = {

  var filtered = List[Int]()

  for(i <- arr) {
    if (i < delim) {
      filtered = filtered:::List(i)
    }
  }

  filtered
}



println(filter(3, List.range(1,10)))
