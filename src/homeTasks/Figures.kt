package homeTasks

import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.round


fun Double.round(decimals: Int = 2): Double {
    val multiplier = 10.0.pow(decimals)
    return round(this * multiplier) / multiplier  // <- Правильный порядок!
}

abstract class Shape(val name: String){

    abstract fun area(): Double
    abstract fun perimeter(): Double

}

class Circle(
    name: String,
    val radius: Double
): Shape(name) {
    init {
        require(radius > 0) { "Радиус не может быть отрицательным, идиотина!" }
    }

    override fun area(): Double = (PI * radius * radius).round(2)
    override fun perimeter(): Double = (2 * PI * radius).round(2)
}

class Rectangle(
    name: String,
    val width: Double,
    val height: Double
): Shape(name) {
    init {
        require(width > 0 && height > 0) { "Отрицательная длина и ширина???? Ты в черной дыре, еблан?" }
    }

    override fun area(): Double = (width * height).round(2)
    override fun perimeter(): Double = 2 * (width + height).round(2)
}

object Shapes {
    fun circle(radius: Double) = Circle("Круг", radius)
    fun rectangle(width: Double, height: Double) = Rectangle("Прямоугольник", width, height)
}