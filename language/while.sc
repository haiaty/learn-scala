
//while loops don't result in a value, to make any kind of difference to your program, a while loop will usually either need to update vars or perform I/O

//be a bit suspicious of while loops in your code. If there isn't a good justification for a particular while or do-while loop, try to find a way to do the same thing without it


/**
  * ----------
  * While
  * ----------
  *
  * */
var a = 0
while(a < 3) {
  println("while")
  a += 1
}



/**
  * ----------
  * Do While
  * ----------
  *
  * */
var line = ""
do {
  line = readLine()
  println("Read: " + line)
} while (line != "")