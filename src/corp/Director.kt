package corp

data class Director(
    override val name: String,
    override val age: Int,
    override val id: Int = -3,
    override val salary: Int
): Worker(name = name, age = age, id = id, position = Positions.DIRECTOR, salary = salary), Supplier {

    override fun work(){
        println("I'm drinking coffee")
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

    fun askToBringCoffee(assistant: Assistant){
        val drinkName = assistant.bringCoffee()
        println("Thank you, ${assistant.name}, the $drinkName was very delicious")
    }

    fun askToServeClient(consultant: Consultant){
        val howManyClients = consultant.clientServing()
        println("corp.Consultant ${consultant.name} has served $howManyClients")
    }

    fun askToIntroduceHimself(consultant: Consultant){
        val consIntroducing = consultant.sayHi()
    }
}