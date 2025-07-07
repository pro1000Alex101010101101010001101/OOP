package homeTasks

import kotlin.random.Random

class Monster {
    val pawsCount: Int
    val eyesCount: Int
    val fangsCount: Int
    val clawsCount: Int
    val tentaclesCount: Int


    constructor(pawsCount: Int, eyesCount: Int, fangsCount: Int, clawsCount: Int, tentaclesCount: Int){
        this.pawsCount = pawsCount
        this.eyesCount = eyesCount
        this.fangsCount = fangsCount
        this.clawsCount = clawsCount
        this.tentaclesCount = tentaclesCount
    }

    constructor(all: Int):this(all, all, all, all, all )

    constructor(): this(Random.nextInt(1, 10))

    fun info(){
        println("Кол-во лап: $pawsCount\nКол-во глаз: $eyesCount\nКол-во клыков: $fangsCount\nКол-во когтей: $clawsCount\nКол-во щупалец: $tentaclesCount")
    }
}

fun main() {
    val (p, e, f, c, t) = readln().split(" ").map { it.toInt() }
    val monster = Monster(p, e, f, c, t,)

    monster.info()
}

