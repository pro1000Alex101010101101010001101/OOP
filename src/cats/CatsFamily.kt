package cats

abstract class CatsFamily(val paws: Int = 4){

    open fun eat() {
        println("Кушаю")
    }
}