package tools

class ChainSaw(
    val chainSawTireLength: Int,
    val chainLinksCount: Int,
    val chainStep: Double,
    brand: String,
    model: String,
    power: Int,
    weight: Double,
    cableLength: Int,
    price: Price,
    voltage: Int = 220
): PowerTool(brand, model, power, weight, cableLength, price, voltage) {

    override fun turnOn() {
        println("Цепная пила пилит")
    }
}