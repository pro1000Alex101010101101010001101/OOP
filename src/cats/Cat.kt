package cats

class Cat(val name: String): CatsFamily() {

    override fun eat() {
        println("Кушаю вискас")
    }
}