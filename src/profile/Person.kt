package profile

class Person {
    val name: String
    val age: Int
    val weight: Int
    val height: Int

    constructor(name: String, age: Int, weight : Int, height: Int) {
        this.name = name
        this.age = age
        this.weight = weight
        this.height = height
    }


    fun sayHello () = println("Hi, I'm $name\nI'm $age yrs. old\nMy bodyweight: $weight kgs and I'm $height cms tall")

}

