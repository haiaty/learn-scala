/**
  * Create an array of n integers, where the value of n is passed as an argument to the pre-filled function in your editor.
  * This challenge uses a custom checker, so you can create any array of n integers.
  * For example, if n=4, you could return [1,1,1,1], [1,2,3,4], or any other array of equal length.
  */


object solution extends App {

  /*
  * defines the function that will generate the array
  * */
  def createArray(length: Int): Array[Int] = {

    var myArray = new Array[Int](length)

    myArray.map(_ => scala.util.Random.nextInt(length))

  }


  /**
    * an implementation using the ListBuffer
    * @param length
    * @return
    */
  def createList(length: Int): List[Int] = {

    import scala.collection.mutable.ListBuffer

    var numbers = new ListBuffer[Int]

    for(i <- 1 to length)
      numbers += i

    numbers.toList

  }


  //call the function to generate the array
// println(createArray(5).deep.mkString("\n"))


  //println(createList(5).foreach(println))


  println(createArray(5).foreach(println))

}