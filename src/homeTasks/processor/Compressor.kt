package homeTasks.processor

class Compressor(processorName: String): DataProcessor(processorName), Transformable {
    override fun transform(data: String): String {
        return "$processorName преобразовал данные: compressed_$data"
    }
}