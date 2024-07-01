object reverseString{
    def reverse(str:String):String={
        if(str.isEmpty()){
            return ""
        }else{
            return reverse(str.tail)+str.head
        }
    }
    def main(args:Array[String]):Unit={
        println("Enter a string: ")
        val str = scala.io.StdIn.readLine()
        val reverseStr = reverse(str)
        println("Reversed string is "+reverseStr)
    }
}