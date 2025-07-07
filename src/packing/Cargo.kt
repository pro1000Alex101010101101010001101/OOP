package packing

class Cargo(
    val length: Int,
    val width: Int,
    val height: Int,
    val typePacking: String,
    val netWeight: Double,
    val grossWeight: Double
) {

    fun printInfo(){
        println("""
            Длина: $length
            Ширина: $width
            Высота: $height
            Тип упаковки: $typePacking
            Вес нетто: $netWeight
            Вес брутто: $grossWeight
        """.trimIndent())
    }
}