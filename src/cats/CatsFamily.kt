package cats

open class CatsFamily(val paws: Int = 4){

    open fun eat() {
        println("Кушаю")
    }
}