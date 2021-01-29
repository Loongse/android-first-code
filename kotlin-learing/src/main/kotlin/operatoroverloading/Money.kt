package operatoroverloading

class Money(val value: Int) {
    operator fun plus(money: Money): Money {
        val sum = value + money.value
        return Money(sum)
    }

    //重载
    operator fun plus(value: Int): Money {
        val sum = value + this.value
        return Money(sum)
    }
}