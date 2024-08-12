import scala.io.StdIn.readLine

object q2{
  def main(args: Array[String]): Unit = {
    val num = readLine("Enter any number: ").toInt

    val isMultipleOfThree: Int => Boolean = x => x % 3 == 0
    val isMultipleOfFive: Int => Boolean = x => x % 5 == 0
    val isMultipleOfBoth: Int => Boolean = n => isMultipleOfThree(n) && isMultipleOfFive(n)

    num match {
      case x if isMultipleOfBoth(x) =>
        println("Multiple of Both Three and Five")
      case x if isMultipleOfThree(x) =>
        println("Multiple of Three")
      case x if isMultipleOfFive(x) =>
        println("Multiple of Five")
      case _ =>
        println("Not a Multiple of Three or Five")
    }
  }
}
