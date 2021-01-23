package com.example.helloworld

import com.example.helloworld.kobj.Student
import com.example.helloworld.kobj.Study
import com.example.helloworld.kobj.dataclass.CellPhone
import com.example.helloworld.kobj.single.Singleton
import kotlin.math.max

fun main() {
//    print("Hello Kotlin!")
//    val a = 10
//    println("a = $a")
//    val b = 20
//    println("the large number is " + largeNumber(a, b))
//    println(checkNumber(a))
//    val student = Student("long", 20)
//    doStudy(student)
//    val cellPhone1 = CellPhone("long", 1870795.0)
//    val cellPhone2 = CellPhone("long", 1870795.0)
//    println(cellPhone1.toString())
//    println(cellPhone2.toString())
//    println(cellPhone1.brand + cellPhone1.price)
//    println("equals:" + (cellPhone1 == cellPhone2))
//    println("=== :" + (cellPhone1 === cellPhone2))
//    Singleton.getInstance()
    //kotlin集合的使用
    //1 使用add进行添加
//    val list = ArrayList<String>()
//    list.add("long")
//    list.add("chao")
//    list.add("loong")
//    list.add("loongse")
//    println(list.javaClass)//class java.util.ArrayList
//    //2 使用listOf创建一个不变的集合（只读，不能增加、修改删除操作）,目的是遵循kotlin强调的不变性原则
//    val listof = listOf("long", "chao", "loong", "loongse")
//    println(listof.javaClass)//class java.util.Arrays$ArrayList
//    //3 创建一个可变的集合
//    val mutableList = mutableListOf("long", "chao", "loong", "loongse")
//    println(mutableList.javaClass)//class java.util.ArrayList
//    //集合的遍历
//    for (l in list) {
//        println(l)
//    }
//    val upperList = list.filter { it.length < 5 }.map { it.toUpperCase() }//函数式编程：Java也有此函数实现
//    for (s in upperList) {
//        println(s)
//    }

    //Java函数式API的使用
    Thread(object : Runnable {
        override fun run() {
            println("thread is running!")
        }
    }).start()
    //使用lambda进行简化
    Thread { println("thread is running!") }.start()
}

/**
 * 函数使用默认参数
 */
fun defaultTest() {
    //默认的参数可以不传入
    defaultPar(19)
    defaultPar(19, "long")
    //前面参数默认下，要传入后续参数可以声明传入的是哪个参数
    defaultParRev(name = "longchao")
}

fun defaultPar(age: Int, name: String = "longchao") {
    println("name: $name,age $age")
}

fun defaultParRev(age: Int = 19, name: String = "longchao") {
    println("name: $name,age $age")
}

fun doStudy(study: Study?) {
    study?.let {//使用let函数，此函数会传入调用变量，而?表示只有当study不为null的时候才会调用
        it.readBooks()
        it.doHomeWork()
        it.defaultFun()
    }

    //使用let函数写法不受多线程影响（全局变量）
    var stu = Student("long", 20)
    fun doStudyLet() {
        stu?.let {
            it.readBooks()
            it.doHomeWork()
            it.defaultFun()
        }
    }
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