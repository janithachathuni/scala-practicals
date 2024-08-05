object q2{
    def calculateSquare(numbers:List[Int]):List[Int]={
        return numbers.map(num => num*num);
    }

    def main(args:Array[String]):Unit={
        val input = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        val output = calculateSquare(input);
        println("Input: " + input);
        println("Output: "+ output);
    }
}