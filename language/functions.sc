
/*
* ----------------------
*  complete definitionß
* ----------------------
* */

def sum(a:Int, b:Int):Int = {
    return  a + b
}


println(sum(1,2))

/*
* ----------------------
*  without return keyword
* ----------------------
* */

def sum2(a:Int, b:Int):Int = {
    a + b
}


println(sum2(1,2))



/*
* ----------------------
*  one line
*
*  when you have a single instruction that will be returned
* ----------------------
* */

def sum3(a:Int, b:Int):Int = a + b


println(sum3(1,2))