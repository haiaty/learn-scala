val m1 = Map("name" -> "aa", "test" -> "sss")

//
// using for
for ((k,v) <- m1) printf("key: %s, value: %s\n", k, v)


//using pattern matching

m1 foreach {case (key, value) => println (key + "-->" + value)}

//using (tuples)

m1 foreach (x => println (x._1 + "-->" + x._2))


// taking only keys
m1.keys.foreach( (key) => 
 
)
