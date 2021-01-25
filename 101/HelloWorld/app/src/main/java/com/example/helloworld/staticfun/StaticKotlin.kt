package com.example.helloworld.staticfun

class StaticKotlin {
    companion object{
        //使用半生类实现静态方法（伪）
        fun comStaticFalse(){
            println("使用半生类实现静态方法（伪）")
        }
        //使用注解实现静态方法（真）
        @JvmStatic
        fun annStaticTrue(){
            println("使用注解实现静态方法（真）")
        }
    }
}