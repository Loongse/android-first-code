package com.example.helloworld.kobj

class Student2 : Person {
    constructor(name: String, age: Int) : super(name, age) {
        //由于没有主构造函数，所以次构造函数只能调用父类的构造函数
    }
}