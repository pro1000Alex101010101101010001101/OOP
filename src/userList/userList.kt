package userList

enum class Opt(val title: String){

    SHOW("SHOW"), ADD("ADD"), REMOVE("REMOVE"), REMOVE_AT("REMOVE_AT")
}

fun main() {

}

fun task(listUser: List<String>): List<String> {
    val users = listUser.toMutableList()
    chooseOpt(users)
    return users.toList()
}

fun chooseOpt(users: MutableList<String>) {
    val options = Opt.entries

    println("CHOOSE OPTION:")
    for ((index, opt) in options.withIndex()) {
        println("${index + 1} - ${opt.title}")
    }

    when(readln().uppercase()) {
        Opt.SHOW.title -> showUserList(users)
        Opt.ADD.title -> addToUserList(users)
        Opt.REMOVE.title -> removeFromUserList(users)
        Opt.REMOVE_AT.title -> removeFromUserListByIndex(users)
        else -> println("Некорректное значение")
    }
}

fun showUserList(users: List<String>) {
    for (user in users) {
        println(user)
    }
}

fun addToUserList(users: MutableList<String>) {
    println("Введите имя для добавления:")
    val name = readln()
    users.add(name)
    showUserList(users)
}

fun removeFromUserList(users: MutableList<String>) {
    println("Введите имя для удаления:")
    val name = readln()
    if (users.remove(name)) {
        showUserList(users)
    } else {
        println("Элемент не найден")
        showUserList(users)
    }
}

fun removeFromUserListByIndex(users: MutableList<String>) {
    println("Введите индекс для удаления:")
    val index = readln().toIntOrNull()
    if (index != null && index in users.indices) {
        users.removeAt(index)
        showUserList(users)
    } else {
        println("Некорректный индекс")
        showUserList(users)
    }
}