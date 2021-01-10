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
