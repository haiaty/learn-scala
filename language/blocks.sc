
/*
* ----------------------
*  Blocks
* ----------------------
* */

//You can combine expressions by surrounding them with {}
//The result of the last expression in the block is the result of the overall block, too

//executing block without getting the result into a variable
{
  val x = 1 + 1
  x + 1
}

//assign block result  to a variable

val a = {
  val x = 1 + 1
  x + 1
}

println(a)