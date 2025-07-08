package corp

class Appliances(
    name: String,
    brand: String,
    price: Int,
    val power: Int,
):ProductCard(name = name, price = price, brand = brand, productType = ProductType.APPLIANCE)  {

    override fun printInfo() {
        println("Name: $name Brand: $brand Price: $price Power: $power")
    }
}