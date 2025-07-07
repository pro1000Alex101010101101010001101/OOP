package corp

open class Worker(
    val name: String,
    val age: Int,
    val id: Int,
    val position: Positions
){


    open fun work() {
        println("I'm working")
    }

    open fun printInfo(){
        println("Id: $id Name: $name Age: $age Position: $position")
    }

}