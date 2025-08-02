package corp

data class Appliances(
    override val name: String,
    override val brand: String,
    override val price: Int,
    val power: Int,
):ProductCard(name = name, price = price, brand = brand, productType = ProductType.APPLIANCE)  {}