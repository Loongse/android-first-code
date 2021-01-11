package com.example.helloworld

import kotlin.math.max

fun main() {
//    print("Hello Kotlin!")
    val a = 10
    println("a = $a")
    val b = 20
    println("the large number is " + largeNumber(a, b))
}

//fun largeNumber(a: Int, b: Int): Int {
//    return max(a, b)
//}
//大括号只有一行代码的简写
//fun largeNumber(a: Int, b: Int): Int = max(a, b)
//自动类型推导简写
fun largeNumber(a: Int, b: Int) = max(a, b)

//使用if语句
//fun largeNumIf(a: Int, b: Int): Int {
//    if (a > b) return a
//    else return b
//}
//return if语句的结果
//fun largeNumIf(a: Int, b: Int): Int {
//    return if (a > b) a
//    else b
//}

//只有一句直接省略
fun largeNumIf(a: Int, b: Int) = if (a > b) a else b
