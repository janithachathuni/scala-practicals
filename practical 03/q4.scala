object sumE{
    def sumEven(arr: Array[Int]):Int={
        var sum = 0
        for(i <- 0 to arr.length - 1) {
            if(arr(i) % 2 == 0) {
            sum += arr(i)
            }
        }
        return sum
    }

    def main(args: Array[String]):Unit={
        println("No of integers: ");
        val n = scala.io.StdIn.readLine().toInt

        var arr = new Array[Int](n)

        for(i<-0 to n-1){
            println("Enter number "+(i+1))
            arr(i)=scala.io.StdIn.readLine().toInt
        }

        println("The sum of the even numbers entered is "  + sumEven(arr))
    }
}