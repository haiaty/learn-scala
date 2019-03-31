
/*
* ----------------------
*  Map definition
* ----------------------
* */


val romanNumeral = Map(
  1 -> "I", 2 -> "II", 3 -> "III", 4 -> "IV", 5 -> "V"
)

/*
* ----------------------
*  Map accesss
* ----------------------
* */

println(romanNumeral(4))


/**
  * ----------------------------------------------
  * empty definition
  * -----------------------------------------------

  */

var kv = Map.empty[String, String]


/*
* ----------------------
* Mutable Map definition
* ----------------------
* */


val map = scala.collection.mutable.Map[Int, String]()

/*
* ----------------------
* Mutable Map add elements
* ----------------------
* */
map += (1 -> "a")
map += (2 -> "b")


println(map(2))


/**
* ----------------------------------------------
* map of strings
* -----------------------------------------------

*/

var aMapStringTostring = Map.empty[String, String]

kv += ("a" -> "b")

kv("a")