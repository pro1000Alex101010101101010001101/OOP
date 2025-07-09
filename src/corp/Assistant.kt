package corp

class Assistant(
    name: String,
    age: Int,
    id: Int = -4
): Worker(name = name, age = age, id = id, position = Positions.ASSISTANT), Cleaner, Supplier {

    override fun clean() {
        ("My position is Assistant and I'm cleaning the workplace")
    }

    fun bringCoffee(drinkName: String = "Cappuccino", count: Int = 1): String{
        repeat(count){
            println("Get up")
            println("Go to coffee machine")
            println("Press the \"$drinkName\" button")
            println("Wait for $drinkName to bt prepared")
            println("Take coffee")
            println("Bring coffee to director")
            println("Put coffee on the table")
            println("Return to workplace")
        }
        return drinkName
    }

    override fun work(){
        bringCoffee()
    }
}