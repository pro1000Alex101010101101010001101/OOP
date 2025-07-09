package corp

fun main() {
    val accountant = Accountant("Alex", 39)
    val employees: MutableList<Worker> = accountant.loadEmployeesFromFile()

    accountant.chooseOpt()
//    for (employee in employees) {
//        if (employee is Cleaner) {
//            employee.clean()
//        }
//    }
}
//
//    val shoeCard1 = Shoes(name = "Sneakers", brand = "Nike", size = 48.0F, price =  19000)
//
//    shoeCard1.printInfo()
//
//
//
//    accountant.work()
