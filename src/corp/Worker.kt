package corp

open class Worker(
    val name: String,
    val age: Int,
    val id: Int,
    private var salary: Int = 15000,
    val position: Positions
){



    fun setSalary(salary: Int) {
        if (salary < this.salary) {
            println("This salary is too small")
        } else {
            this.salary = salary
        }
    }

    fun getSalary(): Int {
        return this.salary
    }

    open fun work() {
        println("I'm working")
    }

    open fun printInfo(){
        println(this)
    }

    override fun toString(): String {
        return "Id: $id Name: $name Age: $age Position: $position Salary: $salary"
    }


}