package corp

data class Assistant(
    override val name: String,
    override val age: Int,
    override val id: Int = -4,
    override val salary: Int
): Worker(
    name = name,
    age = age,
    id = id,
    position = Positions.ASSISTANT,
    salary = salary
), Cleaner, Supplier {

    override fun clean() {
        ("My position is Assistant and I'm cleaning the workplace")
    }

    override fun copy(
        name: String,
        age: Int,
        id: Int,
        salary: Int,
        positions: Positions
    ): Worker {
        return copy(name= name, age = age, id = id, salary = salary)
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