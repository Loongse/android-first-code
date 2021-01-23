package com.example.helloworld.kobj

//一个类中只能有一个主构造函数(但是可以只存在次构造函数而不存在主构造函数，这时候见student2,)
//1 父类后面表示的是需要调用的父类构造函数，需要在父类中存在才可调用
// 2 在主构造函数中使用val以及var声明的参数会自动成为该类的字段
class Student(val sno: String, val gradle: Int, name: String, age: Int) : Person(name, age), Study {
    //    次构造函数需要使用关键字声明:constructor,且必须调用主构造函数(间接或者直接)
    constructor(name: String, age: Int) : this("", 0, name, age) {}
    constructor() : this("", 0) {}

    override fun readBooks() {
        println(name+"student read books!")
    }

    override fun doHomeWork() {
        println(name+"student do homework!")
    }
}