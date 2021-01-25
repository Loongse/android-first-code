package com.example.helloworld.staticfun
//kotlin实现静态方法
//1、使用单例类:object，由于单例类只生成一个对象，而且写法与Java中的静态方法一致，所以可以这样实现，但是单例类中的方法都将是静态方法
//2、使用哦个伴生类，由于只会玩存在一个伴生类对象，所以也可看作静态方法的实现，但是其本质上只是生成了一个半生类而已
//3、在伴生类的基础上加上@javastatic注解，则会编译成真正的静态方法（在Java与kotlin中都可以调用）
//4、顶层方法实现：顶层方法也会编译成静态方法，顶层方法指的是哪些没有写在类里面的方法，在Java中调用需要***文件.***方法，在kotlin中可以直接调用该方法而不需要导入包

fun main() {
    SingleStatic.singleStatic()//在kotlin中调用单例类中方法写法与Java调用静态类一致
    testStatic()//kotlin中直接调用顶层方法
    StaticKotlin.annStaticTrue()
    StaticKotlin.comStaticFalse()//kotlin中两种半生类静态方法的调用形式一致，但是无注解不是真的编译为静态方法
}

//顶层方法实现静态类
fun testStatic() {
    println("顶层方法实现静态类")
}