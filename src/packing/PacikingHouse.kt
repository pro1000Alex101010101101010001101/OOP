package packing

fun main() {
    val wareHouse = WareHouse()
    val items = readln().split(" ")
    val(l, w, h) = items.take(3).map { it.toInt() }
    val we = items[3].toDouble()
    val deliveryObject = DeliveryObject(l, w, h, we)
    val pack = wareHouse.getPack(deliveryObject)
    val completedPack = wareHouse.packCargo(deliveryObject)
    val cargo = completedPack.printInfo()
}