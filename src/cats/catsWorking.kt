package cats


fun main() {
    val cat = Cat("Barsik")
    val lion = Lion(countInPride = 10)
    val cats = listOf(cat, lion)

    for (cat in cats) {
        cat.eat()
    }
}
