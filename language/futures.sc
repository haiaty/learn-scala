/**
* ----------------------------------------------
* Futures
* -----------------------------------------------

  - Futures let you write concurrent programs without as great a risk of deadlocks and race conditions
  - futures are asynchronous transformations of immutable state
  - Future allows you to specify transformations on Future results and obtain a new future that represents the composition of the two asynchronous computations: example Map, flat Map
  - One advantage of Scala's futures is that they help you avoid blocking.  By avoiding blocking, you can keep the finite number of threads you decide to work with busy
  - it lets you simplify your code and take advantage of multiple processors.
*/

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global


// asynchronously executes the block of code, using
//the global execution context, then completes with the value 42

val fut = Future { Thread.sleep(1000); 21 + 21 }

println("Async operation is completed? : " + fut.isCompleted)

Thread.sleep(1000)

println("Async operation is completed? : " + fut.isCompleted)

println("Async operation value: " +  fut.value)


/**
* ----------------------------------------------
* Operator Map on Future
* -----------------------------------------------

  Note that the operations performed in this example—the future creation,
  the 21 + 21 sum calculation, and the 42 + 1 increment
  may be performed by three different threads (and remenber each thread may run on different core).
*/

val testFutMap = Future { Thread.sleep(1000); 21 + 21 }


val mappedFuture = testFutMap.map(x => x + 1)

println("Async operation is completed? : " + testFutMap.isCompleted)

Thread.sleep(1000)

println("Async operation is completed? : " + testFutMap.isCompleted)

println("Async operation value: " +  testFutMap.value)
println("Mapped future value: " +  mappedFuture.value)



/**
* ----------------------------------------------
* Using for to concatenate futures
* -----------------------------------------------
Because Scala's future also declares a flatMap method, you can transform futures using
a forexpression


  - note: if we change the number of seconds on the testFutFor1, after the Thread.sleep(1000)
  on the main thread the test "resultFuture.isCompleted" will give false because in order to
  be a completed future you need to wait the longest task
*/

val testFutFor1 = Future { Thread.sleep(1000); 1 }

val testFutFor2 = Future { Thread.sleep(1000); 2 }

val resultFuture = for {
  x <- testFutFor1
  y <- testFutFor2
} yield x + y

println("Future resultFulture completed?  : " + resultFuture.isCompleted)

Thread.sleep(1000)
println("Future resultFulture completed?  : " + resultFuture.isCompleted)
println(resultFuture.value)


// keep in mind that Because for expressions serialize their transformations,if you don't create the futures before
//the for expression, they won't run in parallel.
// testFutuFor4 future will need 20 seconds to complete (10 of first future and 10 of second)
val testFutuFor4 = for {
  x <- Future { Thread.sleep(10000); 21 + 21 }
  y <- Future { Thread.sleep(10000); 23 + 23 }
} yield x + y