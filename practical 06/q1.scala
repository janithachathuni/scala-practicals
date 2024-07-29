object Inventories{

    def main(args: Array[String]): Unit={
        val inventory1: Map[Int, (String, Int, Double)] = Map(
        101 -> ("Sugar", 10, 50.0),
        102 -> ("Rice", 5, 20.0),
        103 -> ("Flour", 15, 30.0)
        )
        
        val inventory2: Map[Int, (String, Int, Double)] = Map(
        101 -> ("Sugar", 20, 45.0),
        104 -> ("Dal", 10, 60.0)
        )

        val productNames = retrieveProductNames(inventory1)
        println(s"Product names: ${productNames.mkString(", ")}")

        val totalValue = calculateTotalValue(inventory1)
        println(s"Total value of products: $totalValue")

        val isEmpty = checkIfEmpty(inventory1)
        println(s"Is inventory1 empty? $isEmpty")

        val mergedInventory = mergeInventories(inventory1, inventory2)
        println("Merged inventory: ")
        mergedInventory.foreach { case (id, (name, qty, price)) =>
        println(s"Product ID: $id, Name: $name, Quantity: $qty, Price: $price")
        }

        val productIdToCheck = 102
        checkAndPrintProductDetails(mergedInventory, productIdToCheck)
    }

    def retrieveProductNames(inventory: Map[Int, (String, Int, Double)]): List[String]={
        inventory.values.map(_._1).toList
    }

    def calculateTotalValue(inventory: Map[Int, (String, Int, Double)]): Double={
        inventory.values.map { case (_, qty, price) => qty * price }.sum
    }

    def checkIfEmpty(inventory: Map[Int, (String, Int, Double)]): Boolean={
        inventory.isEmpty
    }

    def mergeInventories(
        inventory1: Map[Int, (String, Int, Double)],
        inventory2: Map[Int, (String, Int, Double)]
        ): Map[Int, (String, Int, Double)]={
        inventory2.foldLeft(inventory1) { case (mergedInventory, (id, (name, qty, price))) =>
                mergedInventory.get(id) match {
                    case Some((existingName, existingQty, existingPrice)) =>
                        mergedInventory.updated(id, (existingName, existingQty + qty, math.max(existingPrice, price)))
                    case None =>
                        mergedInventory + (id -> (name, qty, price))
                }
            }
        }


    def checkAndPrintProductDetails(inventory: Map[Int, (String, Int, Double)], productId: Int): Unit={
        inventory.get(productId) match{
        case Some((name, qty, price)) =>
            println(s"Product ID: $productId, Name: $name, Quantity: $qty, Price: $price")
        case None =>
            println(s"Product with ID $productId does not exist in the inventory.")
        }
    }
}
