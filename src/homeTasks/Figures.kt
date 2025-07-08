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
        roundToTwoDecimals(area)
        return area
    }

    override fun perimeter(): Double {
        val perimeter = 2 * PI * radius
        roundToTwoDecimals(perimeter)
        return perimeter
    }
}

class Rectangle(
    name: String,
    val width: Double,
    val height: Double
): Shape(name) {

    override fun area(): Double {
        val area = width * height
        roundToTwoDecimals(area)
        return area
    }

    override fun perimeter(): Double {
        val perimeter = 2 * (width + height)
        roundToTwoDecimals(perimeter)
        return perimeter
    }
}