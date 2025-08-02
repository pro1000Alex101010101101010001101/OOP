package corp

import kotlin.random.Random

data class Consultant (
    override val name: String,
    override val age : Int,
    override val id: Int = -2,
    override val salary: Int
): Worker(name = name, age = age, id = id, salary = salary, position = Positions.CONSULTANT), Cleaner {

    override fun clean() {
        ("My position is Consultant and I'm cleaning the workplace")
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

    fun sayHi(){
        println("Hi, i'm $name")
        if (age > 0){
            println("Hi, i'm $name and i'm $age yrs old")
        }
    }


    fun clientServing(): Int{
        val howManyClients: Int = Random.nextInt(1, 100)
        repeat(howManyClients){
            println("Client served!")
        }
        return howManyClients
    }

    override fun work(){
        println("I'm serving clients")
    }

}