import scala.io.StdIn.readLine

object calculateInterest{
    def main(args:Array[String]):Unit={
        val depositAmount = readLine("Enter deposit amount: ").toDouble;

        val interest: Double => Double = depositAmount match{
            case x if x <= 20000 => 
                x => x*0.02
            case x if x <= 200000 =>
                x => x*0.04
            case x if x <= 2000000 =>
                x => x*0.035
            case _ => 
                x => x*0.065
        }

        println("interest is: $"+interest(depositAmount));
    }


}