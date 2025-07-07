package corp

class Food(
    name: String,
    brand: String,
    price: Int,
    val calories: Int
): ProductCard(name = name, price = price, brand = brand, productType = ProductType.FOOD) {

    override fun printInfo() {
        super.printInfo()
        println("Calories: $calories")
    }
}