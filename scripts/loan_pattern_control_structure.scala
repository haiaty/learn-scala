//it's withPrintWriter, not user code, that assures the file is closed at the end.
// So it's impossible to forget to close the file

//This technique is called the loan pattern, because a control-abstraction function, such as withPrintWriter,
// opens a resource and "loans" it to a function.

import java.io.{File, PrintWriter}


def withPrintWriter(file: File, op: PrintWriter => Unit) = {
  val writer = new PrintWriter(file)
  try {
    op(writer)
  } finally {
    writer.close()
  }
}



withPrintWriter(
  new File("date.txt"),
  writer => writer.println(new java.util.Date)
)

withPrintWriter(
  new File("date.txt"),
  writer => writer.println("Hello")
)

/**
* ----------------------------------------------
* Using currying
* -----------------------------------------------

*/

def withPrintWriterWithCurrying(file: File)(op: PrintWriter => Unit) = {
  val writer = new PrintWriter(file)
  try {
    op(writer)
  } finally {
    writer.close()
  }
}

//client code
val file = new File("date.txt")
withPrintWriterWithCurrying(file) { writer =>
  writer.println(new java.util.Date)
}