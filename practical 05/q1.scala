import scala.io.StdIn.readLine;

object InventoryManagement{
    def getProductList():List[String]={
        var products:List[String]=List();
        var continue=true;

        while(continue){
            println("---Enter product name. Enter 'done' to exit.---")
            val input=readLine.toLowerCase()

            if(input == "done"){
                continue=false;
            }else{
                products=products:+input;
            }
        }

        products;
    }

    def printProductList(products:List[String]):Unit={
        for(i <- products.indices){
            println(s"${i + 1}: ${products(i)}")
        }
    }

    def getTotalProducts(products:List[String]):Int={
        products.length
    }


    def main(args:Array[String]):Unit={
        val products = getProductList()
        println("Product List\n");
        printProductList(products)
        println("Total number of products is "+getTotalProducts(products));
    }
}