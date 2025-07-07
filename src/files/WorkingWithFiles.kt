package files

import java.io.File

fun main() {
    val file = File("test")
    file.appendText("Hi")
}