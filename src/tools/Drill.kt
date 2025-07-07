package tools

class Drill(
    val drillChuckDiameter: Int,
    val minRotationSpeed: Int,
    val maxRotationSpeed: Int,
    brand: String,
    model: String,
    power: Int,
    weight: Double,
    cableLength: Int,
    price: Price,
    voltage: Int = 220
): PowerTool(brand, model, power, weight, cableLength, price, voltage) {

    override fun turnOn() {
        println("Дрель сверлит")
    }
}