


/**
  * Solution with recursion
  *
  * @param xs
  * @return
  */
def sum(xs: List[Int]): Int = {

  if(xs.isEmpty) return 0

  xs.head  + sum(xs.tail)

}


println(sum(List(1,2,3)))