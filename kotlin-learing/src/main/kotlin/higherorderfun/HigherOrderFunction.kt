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
        n1 + n2//(num1AndNum2(n1+n2))
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
//高阶函数：kotlin内部有一个Function接口，里面有一个待实现的invoke函数，而高阶函数调用了这个invoke函数，
//并把对应的参数传递进去，因此每次使用lambda表达式，会建立一个新的匿名类实例，造成内存开销，为了解决此问题，kotlin提供了
//内联函数inline，只需要在高阶函数前面添加一个inline关键字即可，
//一个简单的高阶函数，接受两个Int类型参数以及一个函数类型参数
//内联函数具体原理：
/**
 * 1、将lambda中的代码替换到函数类型参数调用的地方
 * 2、内联函数中的全部代码替换到函数调用的地方
 */
inline fun num1AndNum2(num1: Int, num2: Int, operation: (Int, Int) -> Int): Int {
    return operation(num1, num2)//->return n1+n2
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