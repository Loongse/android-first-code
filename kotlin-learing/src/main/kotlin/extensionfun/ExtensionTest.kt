package extensionfun

//扩展函数：写法ClassName.***，则在调用时可以直接使用***.***调用
//比如说string，在Java中我们不能继承以及添加内部方法，但是kotlin可以通过扩展函数实现
//在Java中一般使用工具类来实现这样的方法
fun main() {
//    直接进行调用
    println("计算字母个数".lettersCounter())
}

fun String.lettersCounter(): Int {
    var cnt = 0
    for (char in this) {
        if (char.isLetter())
            cnt++
    }
    return cnt
}