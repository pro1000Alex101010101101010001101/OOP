package homeTasks

class Car {
    val brand: String
    val model: String
    val enginePower: Int
    val bodyColor: String


    constructor(brand: String, model: String, enginePower: Int, bodyColor: String) {
        this.brand = brand
        this.model = model
        this.enginePower = enginePower
        this.bodyColor = bodyColor
    }


    fun drive() {
        println(if (enginePower >= 120) "Еду быстро, но недалеко на $brand $model" else "Еду далеко, но небыстро на $brand $model")
    }


    fun refuel(gasStation: String, fuel: String, liters: Int) {
        println("Произведена заправка на A3C \"$gasStation\"")
        println("Марка бензина: $fuel")
        println("Кол-во литров: $liters")
    }


    fun info() = println("$brand $model $enginePower л.с. $bodyColor")
}



fun task() {

    val (b, m, e, bC) = readln().split(" ")
    val firstCarBrand = b
    val firstCarModel = m
    val firstCarEnginePower = e.toInt()
    val firstCarBodyColor = bC
    val firstCar = Car(firstCarBrand, firstCarModel, firstCarEnginePower, firstCarBodyColor)

    firstCar.info()
}


