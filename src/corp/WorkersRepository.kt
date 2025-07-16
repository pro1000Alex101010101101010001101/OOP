package corp

import java.io.File

class WorkersRepository {

    private val fileOfWorkers = File("List_of_workers")
    val workers = loadEmployeesFromFile()

    fun register(worker: Worker) {
        workers.add(worker)
    }


    private fun loadEmployeesFromFile(): MutableList<Worker> {
        val employees: MutableList<Worker> = mutableListOf()

        if (!fileOfWorkers.exists()) fileOfWorkers.createNewFile()

        val content = fileOfWorkers.readText().trim()

        if (content.isEmpty()) {
            return employees
        }

        val posAsStrings = content.split("\n")
        for (posAsString in posAsStrings) {
            val properties = posAsString.split("%")
            val id = properties[0].toInt()
            val name = properties[1]
            val age = properties[2].toInt()
            val salary = properties[3].toInt()
            val type = properties.last()
            val posType = Positions.valueOf(type.uppercase())

            val employee = when (posType) {
                Positions.DIRECTOR -> Director(id = id, name = name, age = age, salary = salary )
                Positions.ACCOUNTANT -> Accountant(id = id, name = name, age = age, salary = salary )
                Positions.ASSISTANT -> Assistant(id = id, name = name, age = age, salary = salary )
                Positions.CONSULTANT -> Consultant(id = id, name = name, age = age, salary = salary )
            }
            employees.add(employee)
        }
        return employees
    }

    fun fireEmployee(id: Int) {
        for (worker in workers) {
            if (worker.id == id) {
                workers.remove(worker)
                break
            }
        }
    }

    fun changeSalary(id: Int, salary: Int) {
        for (worker in workers) {
            if (worker.id == id) {
                worker.setSalary(salary)
            }
        }
    }

    fun saveChanges() {
        val content = StringBuilder()
        for (worker in workers) {
            content.append("${worker.id}%${worker.name}%${worker.age}%${worker.getSalary()}%${worker.position}\n")
        }
        fileOfWorkers.writeText(content.toString())
    }
}