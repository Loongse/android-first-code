package com.example.helloworld

import com.example.helloworld.kobj.Student
import com.example.helloworld.kobj.Study
import kotlin.math.max

fun main() {
//    print("Hello Kotlin!")
//    val a = 10
//    println("a = $a")
//    val b = 20
//    println("the large number is " + largeNumber(a, b))
//    println(checkNumber(a))
    val student = Student("long", 20)
    doStudy(student)

}

fun doStudy(study: Study) {
    study.readBooks()
    study.doHomeWork()
    study.defaultFun()
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

/**
 * 使用when语句
 */
//1 基本使用
//fun getScore(name: String): Int {
//    return when (name) {
//        "long" -> 99
//        "chao" -> 89
//        "ll" -> 79
//        else -> 0
//    }
//}

fun getScore(name: String) = when (name) {
    "long" -> 99
    "chao" -> 89
    "ll" -> 79
    else -> 0
}

//2 使用is判断类型，进行类型匹配
fun checkNumber(num: Number) {
    when (num) {
        is Int -> println("number is Int")
        is Double -> println("number is Double")
        else -> println("number not support")
    }
}

//不带参数的when语句
fun getScoreWithoutParam(name: String) = when {
    name == "long" -> 99//使用==而不是equals去判断对象是否相等
    name == "chao" -> 89
    name == "ll" -> 79
    else -> 0
}

//使用函数表达式作为判断语句
fun getScoreWithFun(name: String) = when {
    name.startsWith("long") -> 100
    name == "long" -> 99//使用==而不是equals去判断对象是否相等
    name == "chao" -> 89
    name == "ll" -> 79
    else -> 0
}