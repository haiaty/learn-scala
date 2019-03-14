/**
 * A Scala JDBC connection example by Alvin Alexander,
 * http://alvinalexander.com
 *
 * MySQL/MariaDB
 */
object DatabaseConnection {

  def main(args: Array[String]) {

    // database connection parameters
    val driver = "com.mysql.cj.jdbc.Driver"
    var host = "<my_host>"
    var schema = "<my_schema>"
    val username = "<my_username>"
    val password = "<my_password>"
    val url = "jdbc:mysql://" + host + "/" + schema

    var connection: Connection = null

    try {

      // make the connection
      Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)

      // create the statement, and run the select query
      val statement = connection.createStatement()
      val resultSet = statement.executeQuery("SELECT id, field_a FROM table_name")

      while (resultSet.next()) {
        val id = resultSet.getInt("id")
        val fieldA = resultSet.getString("field_a")
        println("id, field_a = " + id + ", " + fieldA)
      }

    } catch {
      case e: Throwable => println(e.toString)
    }

    connection.close()

  }

}
