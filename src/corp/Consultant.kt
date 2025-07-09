package corp

import kotlin.random.Random

class Consultant (
    name: String,
    age : Int,
    id: Int = -2
): Worker(name = name, age = age, id = id, position = Positions.CONSULTANT), Cleaner {

    override fun clean() {
        ("My position is Consultant and I'm cleaning the workplace")
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