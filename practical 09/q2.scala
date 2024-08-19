import scala.io.StdIn.readLine

object Patterns{
  def main(args: Array[String]): Unit ={
    val num = readLine("Enter a number: ").toInt

    val patternMatching: Int => String = {
      case x if x <= 0 => "Negative/Zero"
      case x if x % 2 == 0 => "Even number"
      case _ => "Odd number"
    }

    println(num + " is a " + patternMatching(num))
  }
}
