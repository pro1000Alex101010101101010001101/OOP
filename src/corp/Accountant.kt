package corp

import java.io.File


class Accountant(
    name: String,
    age: Int,
    id: Int = -1,
    salary: Int
): Worker(
    name = name,
    age = age,
    salary = salary,
    id = id,
    position = Positions.ACCOUNTANT
), Cleaner, Supplier {

    override fun clean() {
        ("My position is Accountant and I'm cleaning the workplace")
    }

    override fun work() {
        chooseOpt()
    }

    private val productsRepository = ProductsRepository()
    private val workersRepository = WorkersRepository()

    private fun chooseOpt() {
        while (true) {
            val operations = Operation.entries
            print("\nEnter operation:\n")
            for ((index, operation) in operations.withIndex()) {
                println("$index - ${operation.command}")
            }
            print("Operation: ")
            when (readln().toIntOrNull()) {
                0 -> {
                    workersRepository.saveChanges()
                    return
                }
                1 -> registerProduct()
                2 -> showAllProducts()
                3 -> removeProductCard()
                4 -> registerNewEmployee()
                5 -> fireEmployee()
                6 -> showAllEmployees()
                7 -> changeSalary()
                else -> println("Invalid operation!")
            }
        }
    }

    private fun changeSalary() {
        print("Enter the id of employee you want change salary: ")
        val id = readln().toInt()
        print("Enter new salary: ")
        val salary = readln().toInt()
        workersRepository.changeSalary(id = id, salary = salary)
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
        productsRepository.saveProductCard(card)
        println("The product has been registered!")
    }

    private fun showAllProducts() {
        val cards: MutableList<ProductCard> = productsRepository.products
        for (card in cards) {
            card.printInfo()
        }
    }

    private fun removeProductCard() {
        print("Enter the name of card you want to remove: ")
        val name = readln()
        productsRepository.removeProductCard(name)
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
        print("Enter salary: ")
        val salary = readln().toInt()
        val worker = when (positionType) {
            Positions.DIRECTOR -> Director(id = id, name = name, age = age, salary = salary)
            Positions.ACCOUNTANT -> Accountant(id = id, name = name, age = age, salary = salary )
            Positions.ASSISTANT -> Assistant(id = id, name = name, age = age, salary = salary)
            Positions.CONSULTANT -> Consultant(id = id, name = name, age = age, salary = salary)
        }
        workersRepository.register(worker)
        println("EMPLOYEE HAS BEEN HIRED!")
    }

    private fun fireEmployee() {
        print("Enter the id of employee you want fire: ")
        val id = readln().toInt()
        workersRepository.fireEmployee(id = id)
    }

    private fun showAllEmployees() {
        val employees: MutableList<Worker> = workersRepository.workers

        if (employees.isEmpty()) {
            println("You need to add someone first!")
            return
        }

        for (employee in employees) {
            employee.printInfo()
        }
    }
}
