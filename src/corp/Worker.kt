package corp

abstract class Worker(
    open val name: String,
    open val age: Int,
    open val id: Int,
    open val salary: Int = 15000,
    open val position: Positions
) {

    abstract fun copy(
        name: String = this.name,
        age: Int = this.age,
        id: Int = this.id,
        salary: Int = this.salary,
        positions: Positions = this.position
    ): Worker


    abstract fun work()

    open fun printInfo() {
        println(this)
    }
}