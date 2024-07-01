import scala.io.StdIn.readLine

object findAvg{
    def mean(n1:Int, n2:Int):Float={
        val avg = (n1.toFloat + n2.toFloat)/2
        val roundVal = math.round(avg * 100.0)/100.0
        return roundVal.toFloat
    }
    def main(args:Array[String]):Unit={
        println("Enter first number: ");
        val n1 = readLine().toInt

        println("Enter second number: ");
        val n2 = readLine().toInt

        println("Mean is "+mean(n1, n2))
    }
}