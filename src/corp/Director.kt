package corp

class Director(
    name: String,
    age: Int,
    id: Int = -3,
    salary: Int
): Worker(name = name, age = age, id = id, position = Positions.DIRECTOR, salary = salary), Supplier {

    override fun work(){
        println("I'm drinking coffee")
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