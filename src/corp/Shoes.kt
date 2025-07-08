package corp

class Shoes(
    name: String,
    brand: String,
    price: Int,
    val size: Float,
): ProductCard(name = name, price = price, brand = brand, productType = ProductType.SHOE) {

    override fun printInfo() {
        println("Name: $name Brand: $brand Price: $price Size: $size")
    }
}