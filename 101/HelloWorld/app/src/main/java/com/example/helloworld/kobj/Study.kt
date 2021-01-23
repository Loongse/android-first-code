package com.example.helloworld.kobj

interface Study {
    fun readBooks()
    fun doHomeWork()
    fun defaultFun() {
        //默认实现
        println("default interface fun")//实现其的类可不重写方法
    }
}