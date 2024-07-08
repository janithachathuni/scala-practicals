object q2{
    def PatternMatching(n:Int):Unit=n match{
        case n if (n<=0) => println("Negative/Zero")
        case n if (n%2 == 0) => println("Even number")
        case n if (n%2 != 0) => println("Odd number")
    }

    def main(args:Array[String]):Unit={
        println("Enter a numberr: ")
        val num = scala.io.StdIn.readLine().toInt
        PatternMatching(num)
    }
}