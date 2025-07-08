package homeTasks

import kotlin.math.round
import kotlin.math.PI

abstract class Shape(val name: String){

    abstract fun area(): Double
    abstract fun perimeter(): Double

    protected fun roundToTwoDecimals(value: Double): Double{
        val roundedValue = round(value * 100) / 100
        return roundedValue
    }
}

class Circle(
    name: String,
    val radius: Double
): Shape(name) {

    override fun area(): Double {
        val area = PI * radius * radius
        return roundToTwoDecimals(area)
    }

    override fun perimeter(): Double {
        val perimeter = 2 * PI * radius
        return roundToTwoDecimals(perimeter)
    }
}

class Rectangle(
    name: String,
    val width: Double,
    val height: Double
): Shape(name) {

    override fun area(): Double {
        val area = width * height
        return roundToTwoDecimals(area)
    }

    override fun perimeter(): Double {
        val perimeter = 2 * (width + height)
        return roundToTwoDecimals(perimeter)
    }
}