package async

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.control.NonFatal

object Async {

  /**
    * Transforms a successful asynchronous `Int` computation
    * into a `Boolean` indicating whether the number was even or not.
    * In case the given `Future` value failed, this method
    * should return a failed `Future` with the same error.
    */
  def transformSuccess(eventuallyX: Future[Int]): Future[Boolean] = {

    eventuallyX.map(number => number % 2 == 0)
  }


  /**
    * Transforms a failed asynchronous `Int` computation into a
    * successful one returning `-1`.
    * Any non-fatal failure should be recovered.
    * In case the given `Future` value was successful, this method
    * should return a successful `Future` with the same value.
    */
  def recoverFailure(eventuallyX: Future[Int]): Future[Int] = {
    eventuallyX recover {
      case NonFatal(t) => -1
    }
  }


  /**
    * Perform two asynchronous computation, one after the other. `makeAsyncComputation2`
    * should start ''after'' the `Future` returned by `makeAsyncComputation1` has
    * completed.
    * In case the first asynchronous computation failed, the second one should not even
    * be started.
    * The returned `Future` value should contain the successful result of the first and
    * second asynchronous computations, paired together.
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

  /**
    * Concurrently perform two asynchronous computations and pair their successful
    * result together.
    * The two computations should be started independently of each other.
    * If one of them fails, this method should return the failure.
    */
  def concurrentComputations[A, B](
                                    makeAsyncComputation1: () => Future[A],
                                    makeAsyncComputation2: () => Future[B]
                                  ): Future[(A, B)] = {
    makeAsyncComputation1() zip makeAsyncComputation2()
  }

  /**
    * Attempt to perform an asynchronous computation.
    * In case of failure this method should try again to make
    * the asynchronous computation so that at most `maxAttempts`
    * are eventually performed.
    */
  def insist[A](makeAsyncComputation: () => Future[A], maxAttempts: Int): Future[A] =
  {
    if(maxAttempts == 0) throw new Exception("Max attempts done")

    makeAsyncComputation() recoverWith {
      case e => insist(makeAsyncComputation, maxAttempts - 1)
    }

  }

}


/**
* ----------------------------------------------
* TEST
* -----------------------------------------------

*/

package async

import java.util.concurrent.atomic.AtomicInteger

import org.scalatest.FunSuite

import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, Future, Promise, TimeoutException}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Random, Success, Try}

class AsyncSuite extends FunSuite {

  /**
    * Returns a function that performs an asynchronous
    * computation returning the given result after 50 milliseconds.
    */
  def delay[A](result: Try[A]): () => Future[A] = {
    val t = new java.util.Timer()
    () => {
      val p = Promise[A]()
      val task = new java.util.TimerTask {
        def run(): Unit = {
          p.complete(result)
          ()
        }
      }
      t.schedule(task, 200 /* milliseconds */)
      p.future
    }
  }

  test("transformSuccess should transform successful computations") {
    val x = Random.nextInt()
    val eventuallyResult =
      Async.transformSuccess(Future.successful(x))
    val result =
      Await.ready(eventuallyResult, 100.milliseconds).value.get
    assertResult(Success(x % 2 == 0))(result)
  }

  test("transformSuccess should propagate the failure of a failed computation") {
    val failure = new Exception("Failed asynchronous computation")
    val eventuallyResult =
      Async.transformSuccess(Future.failed(failure))
    val result =
      Await.ready(eventuallyResult, 100.milliseconds).value.get
    assertResult(Failure(failure))(result)
  }

  test("recoverFailure should recover from failed computations") {
    val eventuallyResult =
      Async.recoverFailure(Future.failed(new Exception))
    val result = Await.ready(eventuallyResult, 100.milliseconds).value.get
    assertResult(Success(-1))(result)
  }

  test("recoverFailure should propagate successful computations") {
    val x = Random.nextInt()
    val eventuallyResult =
      Async.recoverFailure(Future.successful(x))
    val result = Await.ready(eventuallyResult, 100.milliseconds).value.get
    assertResult(Success(x))(result)
  }

  test("sequenceComputations should start the second computation after the first has completed") {
    try {
      val eventuallyResult =
        Async.sequenceComputations(delay(Success(1)), delay(Success(2)))
      Await.ready(eventuallyResult, 300.milliseconds)
      fail("Asynchronous computations finished too early")
    } catch {
      case _: TimeoutException =>
        ()
    }
  }

  test("sequenceComputations should not start the second computation if the first has failed") {
    val counter = new AtomicInteger(0)
    val eventuallyResult =
      Async.sequenceComputations(
        () => Future.failed(new Exception),
        () => Future.successful { counter.incrementAndGet(); () }
      )
    Await.ready(eventuallyResult, 100.milliseconds)
    assertResult(0)(counter.get())
  }

  test("concurrentComputations should start both computations independently of each other’s completion") {
    try {
      val eventuallyResult =
        Async.concurrentComputations(delay(Success(1)), delay(Success(2)))
      Await.ready(eventuallyResult, 350.milliseconds)
      ()
    } catch {
      case _: TimeoutException =>
        fail("Asynchronous computations took too much time")
    }
  }

  test("insist should not retry successful computations") {
    val counter = new AtomicInteger(0)
    val eventuallyResult =
      Async.insist(() => Future { counter.incrementAndGet() }, maxAttempts = 3)
    Await.ready(eventuallyResult, 100.milliseconds).value.get
    assertResult(1)(counter.get())
  }

  test("insist should retry failed computations") {
    val counter = new AtomicInteger(0)
    val eventuallyResult =
      Async.insist(
        () => Future { counter.incrementAndGet(); throw new Exception },
        maxAttempts = 3
      )
    Await.ready(eventuallyResult, 200.milliseconds).value.get
    assertResult(3)(counter.get())
  }

}

