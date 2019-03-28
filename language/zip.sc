/**
* ----------------------------------------------
*  Zip operator on array
* -----------------------------------------------

*/

val arr1 = Array(1, 2, 3)
val arr2 = Array(4, 5, 6)

val zipResult = arr1 zip arr2

// the result is an array of Tuples - Array[(Int, Int)]

println(zipResult) // Array((1,4), (2,5), (3,6))

/**
* ----------------------------------------------
* If one of the two operand arrays is longer than the other,
  zip will drop the remaining elements
* -----------------------------------------------

*/

val arr1longer = Array(1, 2, 3)
val arr2shorter = Array(4, 5)

val zipResult2 = arr1longer zip arr2shorter

// the result is an array of Tuples - Array[(Int, Int)]

println(zipResult2) // Array((1,4), (2,5))