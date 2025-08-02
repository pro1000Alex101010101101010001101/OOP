package corp

data class Shoes(
    override val name: String,
    override val brand: String,
    override val price: Int,
    val size: Float,
): ProductCard(name = name, price = price, brand = brand, productType = ProductType.SHOE) {
}