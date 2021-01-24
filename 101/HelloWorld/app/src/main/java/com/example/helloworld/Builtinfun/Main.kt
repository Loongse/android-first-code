package com.example.helloworld.Builtinfun

import com.example.helloworld.doStudy
import com.example.helloworld.kobj.Student
val stu = Student("long", 19)
//内置函数使用
fun main() {
    val res = stu?.let {
        it.doHomeWork()
        180
    }

    println(res)//180也就是最后一行
    println(testLet())//18 return返回的值
    println(testAlso())//返回传入的对象
}

fun testLet(): Int {
    stu?.let {
        return 18
    }
}
fun testAlso(): String {
    return "long".also {
        println("测试also函数")
    }
}
fun testWith(){
    //调用一个对象的多个方法，只需要写方法，不需要重复对象名
    with(stu){
        //内部返回
        doHomeWork()
    }
}
fun testRun(){
    stu?.run {
        doHomeWork()
        readBooks()
    }
}