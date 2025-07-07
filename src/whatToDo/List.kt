package whatToDo

import java.io.File

fun main() {
    chooseOpt()
}

fun chooseOpt(){
    val listFile = File("List.txt")

    while (true) {
        println("\nChoose operation code:")
        println("1 - Exit")
        println("2 - Add task to list")
        println("3 - Show list")
        println("4 - Delete list")
        print("> ")

        when (readln().toIntOrNull()) {
            1 -> return
            2 -> createListWhatToDo(listFile)
            3 -> showList(listFile)
            4 -> deleteTheList(listFile)
            else -> println("Invalid code! Try again.")
        }
    }
}

fun createListWhatToDo(listFile: File){
    print("What to do: ")
    val task = readln()
    listFile.appendText("$task\n")
    println("Task added!")
}

fun showList(listFile: File) {
    if (!listFile.exists()) {
        println("List is empty! Add tasks first.")
        return
    }

    val text = "--- Your To-Do List ---"
    val slash = "-"
    println("\n" + text)

    listFile.readLines().forEachIndexed { index, task ->
        println("${index + 1} - $task")
    }
    println(slash.repeat(text.length))
}

fun deleteTheList(listFile: File){
    if (listFile.exists()){
        if(listFile.delete()){
            println("File deleted successfully")
        }else{
            println("The list can't be deleted")
        }
    }else{
        println("The list is already deleted")
    }
}

