package sealedcls

//使用密封类包装Result接口
sealed class Result
class Success(val msg: String) : Result()
class Failure(val error: Exception) : Result()

/**
 * 重点：实现有i笑傲的代码保护以及减去无效的when语句else判断
 */

//使用密封类后，when语句中需要提供所有的密封类子类作为判断条件，且不需要为了满足编译要求而加上多余的else分支
//密封类及其所有的子类只能定义在同一个文件的顶层位置，不能嵌套在其他类中
//密封类不能被实例化
//密封类用于表示受限的类继承结构，普通的继承类使用open关键字定义，在项目中的类都可以继承至该类
//密封类的子类必须是在密封类的内部或者必须存在与密封类的同意文件，也就是实现有效的代码保护
//和枚举类的区别：枚举类中的每一个枚举常量只能存在一个实例但是密封类的子类可以存在多个实例
fun getMessage(result: Result) = when (result) {
    is Success -> result.msg
    is Failure -> "error is ${result.error.message}"
}

fun testSealed() {
//    val test = Result()
//    Sealed types cannot be instantiated
}