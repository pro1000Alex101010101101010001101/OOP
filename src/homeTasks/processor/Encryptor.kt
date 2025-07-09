package homeTasks.processor

class Encryptor(processorName: String): DataProcessor(processorName), Transformable {
    override fun transform(data: String): String {
        return "$processorName преобразовал данные: encoded_$data"
    }
}