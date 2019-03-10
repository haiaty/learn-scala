import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Success, Failure}

//resources for future: http://allaboutscala.com/tutorials/chapter-9-beginner-tutorial-using-scala-futures/


// -

/**
  * literal function that will create a future returning an integer
  */
val makeAsyncComputation1 = () => {
  Future {Thread.sleep(1000); 1}
}

/**
  * Another literal function that will create a future returning an integer
  */
val makeAsyncComputation2 = () => {
  Future {Thread.sleep(1000); 2}
}

/***
  * given to functions that returns a future,
  * run the first one and then the second one, and return their values in a tuple
  * @param makeAsyncComputation1
  * @param makeAsyncComputation2
  * @tparam A
  * @tparam B
  * @return
  */
def sequenceComputations[A, B](
      makeAsyncComputation1: () => Future[A],
      makeAsyncComputation2: () => Future[B]
  ): Future[(A, B)] = {

  for {
    x <- makeAsyncComputation1()
    y <- makeAsyncComputation2()
  } yield (x,y)

}

// the sequenceComputations generated a future that will yield the results of the
// two async computations
val newFuture  = sequenceComputations(makeAsyncComputation1, makeAsyncComputation2)

//in order to get the futures completed
//we block the main thread
Thread.sleep(3000);

//in order to have the value generated from the future we have the onComplete
newFuture onComplete {
  case Success(res) => println("onComplete: " + res)
  case Failure(ex) => println(ex)
}

//or we can do this
for (res <- newFuture) println("received" + res)


println("end")
