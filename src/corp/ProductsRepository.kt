package corp

import java.io.File

class ProductsRepository {

    private val file = File("ProductList")
    val products  = loadCardsFromFile()

    fun saveProductCard(productCard: ProductCard) {
        products.add(productCard)
    }

    private fun loadCardsFromFile(): MutableList<ProductCard> {
        val cards: MutableList<ProductCard> = mutableListOf()

        if (!file.exists()) file.createNewFile()

        val content = file.readText().trim()

        if (content.isEmpty()) {
            return cards
        }

        val cardsAsString = content.split("\n")
        for (cardAsString in cardsAsString) {
            val properties = cardAsString.split("%")
            val name = properties[0]
            val brand = properties[1]
            val price = properties[2].toInt()
            val type = properties.last()
            val productType = ProductType.valueOf(type)
            val productCard = when(productType) {
                ProductType.FOOD -> {
                    val calories = properties[3].toInt()
                    Food(name, brand, price, calories)
                }
                ProductType.APPLIANCE -> {
                    val power = properties[3].toInt()
                    Appliances(name, brand, price, power)
                }
                ProductType.SHOE -> {
                    val size = properties[3].toFloat()
                    Shoes(name, brand, price, size)
                }
            }
            cards.add(productCard)
        }
        return cards
    }

    fun removeProductCard(name: String) {
        for (product in products){
            if (product.name == name){
                products.remove(product)
                println("THE PRODUCT HAS BEEN DELETED!")
                break
            }
        }
    }

    fun saveChanges() {
        val content = StringBuilder()
        for (product in products){
            val upgradedContent = content.append("${product.name}%${product.brand}%${product.price}%")
            when (product) {
                is Food -> upgradedContent.append("${product.calories}%${ProductType.FOOD}\n")
                is Appliances -> upgradedContent.append("${product.power}%${ProductType.FOOD}\n")
                is Shoes -> upgradedContent.append("${product.size}%${ProductType.FOOD}\n")
            }
        }

    }
}