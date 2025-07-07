package profile

fun main() {

    print("What is ur name: ")
    val firstName = readln()

    print("What is ur name: ")
    val secondName = readln()

    print("What is ur age: ")
    val firstAge = readln().toInt()

    print("What is ur age: ")
    val secondAge = readln().toInt()

    print("What is ur weight: ")
    val firstWeight = readln().toInt()

    print("What is ur weight: ")
    val secondWeight = readln().toInt()

    print("What is ur height: ")
    val firstHeight = readln().toInt()

    print("What is ur height: ")
    val secondHeight = readln().toInt()

    val first = Person(firstName, firstAge,firstWeight, firstHeight)
    val second = Person(name = secondName, age = secondAge, weight = secondWeight, height = secondHeight)

    first.sayHello()
    second.sayHello()
}