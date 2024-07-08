object q2{
    var item: Array[String] = Array("rice", "sugar", "soap", "flour")
    var quantity:Array[Int] = Array(5, 4, 3, 2)

    def displayInventory():Unit={
        println("Inventory: ")
        for(i <- 0 until item.length){
            println(item(i)+ " : "+ quantity(i))
        }
        println("")
    }

    def restockItem(itemName:String, itemQuantity:Int):Unit={
        val index = item.indexOf(itemName)
        if(index != -1){
            quantity(index) = quantity(index)+itemQuantity
            println("Restocked - "+item(index)+ " : "+ quantity(index))
        }else{
            println("Item "+ itemName+" does not exist in inventory.")
        }
    }

    def sellItem(itemName:String, itemQuantity:Int):Unit={
        val index = item.indexOf(itemName)
        if(index != -1){
            if(quantity(index)>=itemQuantity){
                quantity(index) = quantity(index) - itemQuantity
            }else{
                println("Sorry, Not enough "+ itemName+" in stock to sell.")
            }
        }else{
            println(itemName + " does not exist in inventory.")
        }
    }

    def main(args:Array[String]):Unit={
        displayInventory()

        restockItem("rice", 5)
        displayInventory()

        sellItem("soap", 2)
        displayInventory()
    }
}