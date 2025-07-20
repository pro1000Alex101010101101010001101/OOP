package corp

fun main() {
    val workers = WorkersRepository.workers
    for (worker in workers) {
        worker.work()
        if (worker is Cleaner) {
            worker.clean()
        }
    }
}
//
//    val shoeCard1 = Shoes(name = "Sneakers", brand = "Nike", size = 48.0F, price =  19000)
//
//    shoeCard1.printInfo()
//
//
//
//    accountant.work()
