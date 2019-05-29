
import java.sql.{Connection, DriverManager, PreparedStatement}

import scala.collection.mutable
import scala.util.Random
import com.github.vickumar1981.stringdistance.Strategy
import com.github.vickumar1981.stringdistance.StringDistance._
import com.github.vickumar1981.stringdistance.StringSound._
import com.github.vickumar1981.stringdistance.impl.{ConstantGap, LinearGap}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

object Index extends App {


  val t0 = System.nanoTime()
  //org.mariadb.jdbc.Driver

  //jdbc:mariadb://{host}[:{port}]/[{database}]

  // connect to the database named "mysql" on port 8889 of localhost
  val url = "jdbc:mariadb://localhost/test"
  val driver = "org.mariadb.jdbc.Driver"
  val username = "root"
  val password = ""
  var connection:Connection = _
  try {

    // CONNECTION
    Class.forName(driver)
    connection = DriverManager.getConnection(url, username, password)


    import java.sql.ResultSet
    val statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)
    statement.setFetchSize(Int.MinValue)


    val Queryfutures = mutable.ListBuffer[Future[Double]]()

    for (i <- 1 to 3) {

      Queryfutures += Future {
        val rs = statement.executeQuery(s"SELECT lev_test FROM test_stream LIMIT 300000")
        // in rs we don’t have any data until the next() method call

        val futures = mutable.ListBuffer[Future[Double]]()

        while (rs.next()) {

          //val levenshteinDist: Int = Levenshtein.distance("martha", rs.getString(1))  // 2

          val str: String = rs.getString(1)

          futures += Future {
            Levenshtein.score("martha", str)
          }

          //result += rs.getString(1)
        }


        /* val x: Double =  futures.foldLeft(0) { (acc, f) =>


         }*/


        val nnn = Future.foldLeft[Double, Double](futures.toList)(0)(_ + _ )


        val x = Await.result(nnn, Duration.Inf)

        x
      }
    }



    val finalResultFuture = Future.foldLeft[Double, Double](Queryfutures.toList)(0)(_ + _ )

    val x = Await.result(finalResultFuture, Duration.Inf)

    println(x)

    // val res = result.toLis
    val t1 = System.nanoTime()
    println("Elapsed time: " + (t1 - t0) + "ns")


    /*for (i <- 1 to 1000000) {

      val insertSql = """
                        |insert into test_stream (lev_test)
                        |values (?)
                      """.stripMargin

      val preparedStmt: PreparedStatement = connection.prepareStatement(insertSql)

      preparedStmt.setString (1, Random.alphanumeric.take(10).mkString)
      preparedStmt.execute

      preparedStmt.close()


    }*/



    /*val statement = connection.createStatement
    val rs = statement.executeQuery("INSERT into")
    while (rs.next) {
      val host = rs.getString("host")
      val user = rs.getString("user")
      println("host = %s, user = %s".format(host,user))
    }*/
  } catch {
    case e: Exception => e.printStackTrace
  }
  connection.close
}

