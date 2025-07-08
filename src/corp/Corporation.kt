package corp

fun main() {
    val accountant = Accountant("Alex", 39)
    val employees = accountant.loadEmployeesFromFile()

    for (employee in employees) {
        if (employee is Cleaner) {
            employee.clean()
        }
        if (employee is Supplier) {
            employee.buyThings()
        }
    }
}

//
//    val shoeCard1 = Shoes(name = "Sneakers", brand = "Nike", size = 48.0F, price =  19000)
//
//    shoeCard1.printInfo()
//
//
//
//    accountant.work()
