
/**
  * ATTENTION: you will need the JDBC driver for run this code
  * Make sure you have it.
  * note: you can put the .jar  into a lib/ folder
  */

import java.sql.{Connection, DriverManager, PreparedStatement}

import scala.util.Random


object Index extends App {



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


    // INSERT INTO 1000000 rows
    for (i <- 1 to 1000000) {

      val insertSql = """
                        |insert into test_stream (lev_test)
                        |values (?)
                      """.stripMargin

      val preparedStmt: PreparedStatement = connection.prepareStatement(insertSql)

      preparedStmt.setString (1, Random.alphanumeric.take(10).mkString)
      preparedStmt.execute

      preparedStmt.close()


    }

  } catch {
    case e: Exception => e.printStackTrace
  }
  connection.close
}

