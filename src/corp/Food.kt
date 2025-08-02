package corp

data class Food(
    override val name: String,
    override val brand: String,
    override val price: Int,
    val calories: Int
): ProductCard(name = name, price = price, brand = brand, productType = ProductType.FOOD) {
}