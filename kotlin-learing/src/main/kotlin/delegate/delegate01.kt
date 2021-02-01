package delegate

interface Base {
    fun print()

    //增加两个方法
    fun printMessage()
    fun printMessageLine()

    //增加一个成员
    val message: String
}

class BaseImpl(val x: Int) : Base {
    override val message = "BaseImpl: x = $x"
    override fun print() {
        print(message)
    }

    override fun printMessage() {
        print(x)
    }

    override fun printMessageLine() {
        println(x)
    }
}

class Derived(b: Base) : Base by b//Derived类将所有的公有成员都给指定的对象来实现一个接口Base
{
    //在b 的print实现中不会i访问到此属性
    override val message = "Message of Derived"
    override fun printMessage() {
        print("abc")
    }
}

fun main() {
    val b = BaseImpl(10)
    Derived(b).print()//输出10
    Derived(b).printMessage()//输出abc，因为Derived类中重写了printMessage方法
    Derived(b).printMessageLine()//输出10

    val derived = Derived(b)
    derived.print()//BaseImpl: x = 10,此处会使用baseimpl的message，因为实际上调用的是baseimpl的print方法
    println(derived.message)//此处输出为Message of Derived，实际调用的是derived本身的message
}