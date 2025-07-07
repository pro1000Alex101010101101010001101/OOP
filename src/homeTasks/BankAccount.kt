package homeTasks


open class BankAccount(private var balance: Int) {

    fun deposit(amount: Int){
        if (amount >= 0) {
            balance += amount
        }
    }

    protected fun withdraw(amount: Int){
        if (!(amount < 0 && amount < balance)) {
            balance -= amount
        }
    }

    fun getBalance(): Int {
        return balance
    }
}


class SpecialBankAccount(balance: Int) : BankAccount(balance = balance) {

    fun specialWithdraw(amount: Int) {
        withdraw(amount)
    }
}