package packing

class WareHouse {

    fun getPack(deliveryObject: DeliveryObject): Pack {
        return Pack(
            length = deliveryObject.length + 1,
            width = deliveryObject.width + 1,
            height = deliveryObject.height + 1
        )
    }

    fun packCargo(deliveryObject: DeliveryObject): Cargo {
        val pack = getPack(deliveryObject) // получаем упаковку

        return Cargo(
            length = pack.length,
            width = pack.width,
            height = pack.height,
            typePacking = pack.type,
            netWeight = deliveryObject.weight,
            grossWeight = pack.weight + deliveryObject.weight)
    }
}
