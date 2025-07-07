package corp

enum class Operation(val command: String) {

    EXIT(command = "Exit"),
    REG(command = "Register new item"),
    SHOW(command = "Show all products"),
    DELETE(command = "Delete the product"),
    REG_NEW_EMPLOYEE(command = "Register new employee"),
    FIRE(command = "Fire the employee"),
    SHOW_EMPLOYEES(command = "Show all employees")
}