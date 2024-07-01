import scala.io.StdIn.readLine

object strings{
    def filterStr(strings: List[String]):List[String]={
        strings.filter(_.length > 5)
    }

    def main(args:Array[String]):Unit={
        println("Enter number of strings: ")
        val n = readLine().toInt
        val list = new Array[String](n)

        for(i<-0 to n-1){
            println("Enter string :")
            list(i)=readLine()
        }

        val filteredList = filterStr(list.toList);
        println(filteredList)
    }
}