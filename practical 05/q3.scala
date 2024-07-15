import scala.io.StdIn.readLine;

object FibonacciSeq{
    def fibonacci(n:Int):Int={
        if(n<=0) 0
        else if (n==1) 1
        else fibonacci(n-1)+fibonacci(n-2)
    }

    def printSeq(n:Int):Unit={
        for(i<-0 until n){
            println(fibonacci(i));
        }
    }

    def main(args:Array[String]):Unit={
        println("Enter a number: ");
        val n = readLine.toInt;
        println("Sequence:");
        printSeq(n)
    }
}