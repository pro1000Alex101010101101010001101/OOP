package exceptions

fun main() {

    fun getListWithoutNull(list: List<Any?>): List<Any?> {
        return list.filterNotNull()
    }
    val massive = getListWithoutNull(listOf<Any?>("Cat", 2, "Awd", null))
    try {
        val indexInput = readln().toIntOrNull()
        println(massive[indexInput?:0])
    } catch (e: ArrayIndexOutOfBoundsException) {
        println("Your index is out of the list")
    } catch (e: IndexOutOfBoundsException) {
        println("Do it again? but I will not crush ur program")
    }
    println("your program is still working")
    println(massive)
}