package com.example.helloworld.staticfun;

public class StaticTest {
    public static void main(String[] args) {
        SingleStatic.INSTANCE.singleStatic();//在Java中调用需要加上instance获取实例
        MainKt.testStatic();//顶层方法实现需要前面加上文件名
        StaticKotlin.annStaticTrue();//直接调用使用注解实现的静态方法
        StaticKotlin.Companion.comStaticFalse();//通过半生类实现的静态方法需要先获取其半生类实例才能实现
    }
}
