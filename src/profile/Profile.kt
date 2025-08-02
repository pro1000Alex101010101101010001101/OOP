package profile

fun main() {

    val first = Person("lex", 23,45, 160, "M")
    val second = Person(name = "mark", age = 21, weight = 75, height = 170, lastName = "B")
    var third = Person("lex", 23,45, 160, "M")

    val persons = mutableSetOf<Person>(first, second, third)

    for (person in persons) {
        person.sayHello()
    }
    third = third.copy(name = "Alex")
    persons.add(third)

    for (person in persons) {
        person.sayHello()
    }
}