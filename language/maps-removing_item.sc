

/**
* ----------------------------------------------
* removing item
* -----------------------------------------------

*/

var map = Map.empty[String, String]

map += ("a" -> "add")
map += ("b" -> "ball")

map("b")


map -= "a"

println(map("a"))