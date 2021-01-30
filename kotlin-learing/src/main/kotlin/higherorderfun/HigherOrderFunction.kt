package higherorderfun


//高阶函数：接收参数或者返回类型为另一个函数的函数称为高阶函数
//函数类型定义形式：(String,Int)->Unit,->右边的是函数的返回类型，而左边是函数的参数
fun main() {
    //测试高阶函数，分别传入两个不同的函数作为参数，测试结果,如果需要传入函数，前面需要使用::标注
    println(num1AndNum2(1, 2, ::plus))
    println(num1AndNum2(1, 2, ::minus))
//函数引用方式： ::
//    使用lambda表达式来使用高阶函数
    println(num1AndNum2(1, 2) { n1, n2 ->
        n1 + n2
    })
    println(num1AndNum2(1, 2) { n1, n2 ->
        n1 - n2
    })
//    使用自定义的 拓展函数
    val list = listOf("long","chao","emmm")
    val result = StringBuilder().build{
        append("this is higher order function\n")
        for (s in list) {
            append(s).append("\n")
        }
        append(".......")
    }
    println(result)
}

//一个简单的高阶函数，接受两个Int类型参数以及一个函数类型参数
fun num1AndNum2(num1: Int, num2: Int, operation: (Int, Int) -> Int): Int {
    return operation(num1, num2)
}

//定义俩个用于加减的函数
fun plus(num1: Int, num2: Int): Int {
    return num1 + num2
}

fun minus(num1: Int, num2: Int): Int {
    return num1 - num2
}

//添加一个扩展函数StringBuilder.表示这个函数在该类中,这样传入的函数就会拥有StringBuilder的上下文
fun StringBuilder.build(block: StringBuilder.() -> Unit): StringBuilder {
    block()
    return this
}