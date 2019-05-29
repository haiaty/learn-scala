
/**
  * you must have the JDBC for your Database
  *
  * sbt dependencies:
  *
  * libraryDependencies += "com.github.vickumar1981" %% "stringdistance" % "1.1.1"
  *
  *
  * OTHER:
  *
  * https://index.scala-lang.org/vickumar1981/stringdistance/stringdistance/1.1.1?target=_2.12
  *
  *
  * SOME RESULTS:
  *
  * with 1 Milion records :  1.7second (Avg)
  * with 500.000 records: 700ms (Avg)
  * with 100.000 records 300ms (avg)
  *
  * */
import java.sql.{Connection, DriverManager, PreparedStatement}

import scala.collection.mutable
import scala.util.Random
import com.github.vickumar1981.stringdistance.Strategy
import com.github.vickumar1981.stringdistance.StringDistance._
import com.github.vickumar1981.stringdistance.StringSound._
import com.github.vickumar1981.stringdistance.impl.{ConstantGap, LinearGap}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object Index extends App {


  val t0 = System.nanoTime()

  val url = "jdbc:mariadb://localhost/test"
  val driver = "org.mariadb.jdbc.Driver"
  val username = "root"
  val password = ""
  var connection:Connection = _
  try {

    // CONNECTION
    Class.forName(driver)
    connection = DriverManager.getConnection(url, username, password)


    //INITIALIZATION OF CONNECTION TO STREAM
    import java.sql.ResultSet
    val statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)
    statement.setFetchSize(Int.MinValue)

    val rs = statement.executeQuery(s"SELECT lev_test FROM test_stream LIMIT 100000")


    // in rs we don’t have any data until the next() method call
    while (rs.next()) {

      val str: String = rs.getString(1)

      Future {Levenshtein.score("martha", str)}

    }


    val t1 = System.nanoTime()
    println("Elapsed time: " + (t1 - t0) + "ns")



    //Need in order to prevent execution of main thread to finish
    // before of futures
    Thread.sleep(2000)

  } catch {
    case e: Exception => e.printStackTrace
  }
  connection.close
}
