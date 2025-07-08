package corp

class Food(
    name: String,
    brand: String,
    price: Int,
    val calories: Int
): ProductCard(name = name, price = price, brand = brand, productType = ProductType.FOOD) {

    override fun printInfo() {
        println("Name: $name Brand: $brand Price: $price Calories: $calories")
    }
}