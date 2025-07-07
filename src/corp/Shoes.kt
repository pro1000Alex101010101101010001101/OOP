package corp

class Shoes(
    name: String,
    brand: String,
    price: Int,
    val size: Float,
): ProductCard(name = name, price = price, brand = brand, productType = ProductType.SHOE) {

    override fun printInfo() {
        super.printInfo()
        println("Size: $size")
    }
}