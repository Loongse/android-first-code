package operatoroverloading

//运算符重载
fun main() {
    val money = Money(5)
    val money1 = Money(6)
    println((money + money1).value)
    println((money + 11).value)
}