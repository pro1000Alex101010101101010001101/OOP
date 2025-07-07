package corp

import java.io.File


class Accountant(
    name: String,
    age: Int,
    id: Int = -1
): Worker(name = name, age = age, id = id, position = Positions.ACCOUNTANT) {

    override fun work() {
        chooseOpt()
    }

    private val file = File("ProductList")
    private val fileOfEmployees = File("List_of_employees")

    fun chooseOpt() {
        while (true) {
            val operations = Operation.entries
            print("\nEnter operation:\n")
            for ((index, operation) in operations.withIndex()) {
                println("$index - ${operation.command}")
            }
            print("Operation: ")
            when (readln().toIntOrNull()) {
                0 -> return
                1 -> registerProduct()
                2 -> showAllProducts()
                3 -> removeProductCard()
                4 -> registerNewEmployee()
                5 -> fireEmployee()
                6 -> showAllEmployees()
                else -> println("Invalid operation!")
            }
        }
    }

    private fun registerProduct() {
        val productTypes = ProductType.entries
        print("Enter product type: ")

        for ((index, type) in productTypes.withIndex()) {
            print("$index - ${type.title}")
            if (index < productTypes.size - 1) {
                print(", ")
            } else {
                print(": ")
            }
        }

        val productTypeIndex = readln().toInt()
        val productType = productTypes[productTypeIndex]
        print("Enter product name: ")
        val name = readln()
        print("Enter product brand: ")
        val brand = readln()
        print("Enter product price: ")
        val price = readln().toInt()
        val card = when (productType) {
            ProductType.FOOD -> {
                print("Enter calories: ")
                val calories = readln().toInt()
                Food(name, brand, price, calories)
            }
            ProductType.APPLIANCE -> {
                print("Enter power: ")
                val power = readln().toInt()
                Appliances(name, brand, price, power)
            }
            ProductType.SHOE -> {
                print("Enter size: ")
                val size = readln().toFloat()
                Shoes(name, brand, price, size)
            }
            else -> {
                println("Invalid choice, try again")
                return
            }
        }
        saveProductCardToFile(card)
        println("The product has been registered!")
    }

    private fun showAllProducts() {
        val cards: MutableList<ProductCard> = loadCardsFromFile()
        for (card in cards) {
            card.printInfo()
        }
    }

    private fun removeProductCard() {
        val cards: MutableList<ProductCard> = loadCardsFromFile()
        print("Enter the name of card you want to remove: ")
        val name = readln()
        for (card in cards){
            if (card.name == name){
                cards.remove(card)
                println("THE PRODUCT HAS BEEN DELETED!")
                break
            }
        }
        file.writeText("")
        for (card in cards) {
            saveProductCardToFile(card)
        }
    }

    private fun loadCardsFromFile(): MutableList<ProductCard> {
        val cards: MutableList<ProductCard> = mutableListOf<ProductCard>()

        if (!file.exists()) file.createNewFile()

        val content = file.readText().trim()

        if (content.isEmpty()) {
            return cards
        }

        val cardsAsString = content.split("\n")
        for (cardAsString in cardsAsString) {
            val properties = cardAsString.split("%")
            val name = properties[0]
            val brand = properties[1]
            val price = properties[2].toInt()
            val type = properties.last()
            val productType = ProductType.valueOf(type)
            val productCard = when(productType) {
                ProductType.FOOD -> {
                    val calories = properties[3].toInt()
                    Food(name, brand, price, calories)
                }
                ProductType.APPLIANCE -> {
                    val power = properties[3].toInt()
                    Appliances(name, brand, price, power)
                }
                ProductType.SHOE -> {
                    val size = properties[3].toFloat()
                    Shoes(name, brand, price, size)
                }
            }
            cards.add(productCard)
        }
        return cards
    }

    private fun saveProductCardToFile(productCard: ProductCard) {
        file.appendText("${productCard.name}%${productCard.brand}%${productCard.price}%")
        when (productCard) {
            is Food -> {
                val calories = productCard.calories
                file.appendText("$calories%${ProductType.FOOD}\n")
            }

            is Appliances -> {
                val power = productCard.power
                file.appendText("$power%${ProductType.APPLIANCE}\n")
            }

            is Shoes -> {
                val size = productCard.size
                file.appendText("$size%${ProductType.SHOE}\n")
            }
        }
    }

    private fun registerNewEmployee() {
        val positions = Positions.entries

        print("Choose position - ")
        for ((index, pos) in positions.withIndex()) {
            print("$index - ${pos.title}")
            if (index < positions.size - 1) {
                print(", ")
            }else{
                print(":")
            }
        }

        val positionIndex = readln().toInt()
        val positionType = positions[positionIndex]

        print("Enter id: ")
        val id = readln().toInt()
        print("Enter name: ")
        val name = readln()
        print("Enter age: ")
        val age = readln().toInt()
        val employee = when (positionType) {
            Positions.DIRECTOR -> Director(id = id, name = name, age = age)
            Positions.ACCOUNTANT -> Accountant(id = id, name = name, age = age)
            Positions.ASSISTANT -> Assistant(id = id, name = name, age = age)
            Positions.CONSULTANT -> Consultant(id = id, name = name, age = age)
        }

        saveEmployeeToFile(employee)
        println("EMPLOYEE HAS BEEN HIRED!")
    }

    private fun saveEmployeeToFile(employee: Worker) {
        fileOfEmployees.appendText("${employee.id}%${employee.name}%${employee.age}%")
        when (employee) {
            is Director -> fileOfEmployees.appendText("${Positions.DIRECTOR}\n")

            is Accountant -> fileOfEmployees.appendText("${Positions.ACCOUNTANT}\n")

            is Assistant -> fileOfEmployees.appendText("${Positions.ASSISTANT}\n")

            is Consultant -> fileOfEmployees.appendText("${Positions.CONSULTANT}\n")
        }
    }

    private fun loadEmployeesFromFile(): MutableList<Worker> {
        val employees: MutableList<Worker> = mutableListOf()

        if (!fileOfEmployees.exists()) fileOfEmployees.createNewFile()

        val content = fileOfEmployees.readText().trim()

        if (content.isEmpty()) {
            return employees
        }

        val posAsStrings = content.split("\n")
        for (posAsString in posAsStrings) {
            val properties = posAsString.split("%")
            val id = properties[0].toInt()
            val name = properties[1]
            val age = properties[2].toInt()
            val type = properties.last()
            val posType = Positions.valueOf(type)

            val employee = when (posType) {
                Positions.DIRECTOR -> Director(id = id, name = name, age = age)
                Positions.ACCOUNTANT -> Accountant(id = id, name = name, age = age)
                Positions.ASSISTANT -> Assistant(id = id, name = name, age = age)
                Positions.CONSULTANT -> Consultant(id = id, name = name, age = age)
            }
            employees.add(employee)
        }
        return employees
    }

    private fun showAllEmployees() {
        val employees: MutableList<Worker> = loadEmployeesFromFile()

        if (employees.isEmpty()) {
            println("You need to add someone first!")
            return
        }

        for (employee in employees) {
            employee.printInfo()
        }
    }

    private fun fireEmployee() {
        val employees: MutableList<Worker> = loadEmployeesFromFile()
        print("Enter the id of employee you want fire: ")
        val id = readln().toInt()

        for (employee in employees) {
            if (id == employee.id) {
                employees.remove(employee)
                println("EMPLOYEE HAS BEE FIRED")
            }
        }
        fileOfEmployees.writeText("")

        for (employee in employees) {
            saveEmployeeToFile(employee)
        }
    }
}


