<!--
 * @Author: longchao
 * @Date: 2021-01-11 12:30:45
 * @LastEditTime: 2021-01-23 10:28:37
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \android-diyihangdaima\101\HelloWorld\app\src\main\java\com\example\helloworld\kobj\kotlin_object.md
-->

# kotlin面向对象基础概念
1. 主构造函数与次构造函数（见student\student2\person）
1. 接口中的默认方法实现（java1.8也存在了）见study
1. kotlin中的四种访问限制修饰符与java对比

|  修饰符   | Java  |kotlin  |
|  ----  | ----  | ------- |
| private  | 当前类可见 | 当前类可见 |
| protected  | 当前类、子类以及同一个包下的类可见 | 当前类、子类可见 |
| public  | 所有类可见 | 所有类可见（默认） |
| default  | 同一包路径下的类可见（默认） | 无 |
| internal  | 无 | 同一模块下的类可见 |