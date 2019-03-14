import scala.sys.process._

// Executes "dir" or "ls" and sends output to stdout
// @see https://stackoverflow.com/questions/21281354/java-io-ioexception-cannot-run-program-dir-createprocess-error-2-das-system

if (System.getProperty("os.name").startsWith("Windows")) {
  "cmd.exe /c dir".!
} else {
  "ls".!
}
