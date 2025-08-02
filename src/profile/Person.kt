package profile

data class Person(
    val name: String,
    val age: Int,
    val weight: Int,
    val height: Int,
    val lastName: String) {

    fun sayHello() {
        println(this)
    }

    override fun toString(): String {
        return "Hi, i'm $name $lastName im $age old"
    }
}