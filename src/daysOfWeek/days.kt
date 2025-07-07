package daysOfWeek

fun main() {
    val days = DaysOfWeek.entries

    for(day in days){
        println(day.title)
    }
}