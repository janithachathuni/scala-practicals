object q3{
    def filterPrime(numbers:List[Int]):List[Int]={
        numbers.filter(num=>{
            if(num == 1 || num == 0 || num < 0){
                false
            }else{
                var isPrime = true;
                for(i <- 2 to num/2){
                    if(num % i == 0){
                        isPrime = false;
                    }
                }

                isPrime;
            }
        })
    }

    def main(args:Array[String]):Unit={
        val input = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        val output = filterPrime(input);

        println("Input: " + input);
        println("Output: " + output);
    }
}