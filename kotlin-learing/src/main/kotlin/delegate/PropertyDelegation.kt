package delegate

import javax.swing.UIDefaults
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

//属性委托
class Example {
    var p: String by Delegate()

    //默认情况下，对于lazy属性求值是同步锁的，
    // 但是使用LazyThreadSafetyMode.PUBLICATION后
//    用于初始化委托的同步锁不是必须的情况
//    如果确定初始化总是发生在与属性使用位于相同的线程，
//    可以使用LazyThreadSafetyMode.NONE，这时不会有任何线程安全的保证以及相关的开销
    val lazyValue: String by lazy(LazyThreadSafetyMode.PUBLICATION) {

        println("computed")
        "Hello"
    }
}

class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef,thank you for delagating! '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef")
    }

}

//可观察属性observable
class User {
    var name: String by Delegates.observable("<no name>") { property, oldValue, newValue ->
        println("$oldValue->$newValue")
    }
    var nameVetoable: String by Delegates.vetoable("<vetoable name>", ::onChangeFun)
}

fun onChangeFun(property: KProperty<*>, oldVallue: String, newValue: String): Boolean {
    return newValue.length >= oldVallue.length
}

//委托给另一个属性
class MyClass {
    //以一种向后兼容的方式重命名一个属性，引入一个新的属性，同时使用deprecated注解注解旧的实现并委托给新的实现
    var newName: Int = 0

    @Deprecated("Use 'newName' instead", ReplaceWith("newName"))
    var oldName: Int by this::newName
}

//将属性储存在映射中
class UseMap(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int by map//Map是只读的，MutableMap是可读写的
}

fun main() {
    val e = Example()
    println(e.p)//调用委托类的getValue方法
    e.p = "NEW"//赋值时调用setValue方法

    println(e.lazyValue)//只会在首次调用该lazyValue时才会执行表达式
    println(e.lazyValue)//后续调用会直接返回记录的结果
    //computed
    //Hello
    //Hello

    val myClass = MyClass()
//    会自动委托给新的实现
    myClass.oldName = 42
    println(myClass.newName)//输出42

    val user = User()
    user.name = "first"
    user.name = "second"

    user.nameVetoable = "longchao test vetoable"
    println(user.nameVetoable)//通过否决会改变
    user.nameVetoable = "longchao"
    println(user.nameVetoable)//未通过不会改变其值

    //将属性储存在映射中
    val userMap = UseMap(
        mapOf(
            "name" to "LongChao",
            "age" to 25
        )
    )
    //委托属性会从映射中取值（通过字符串键--属性的名称）
    println(userMap.name)
    println(userMap.age)
    println(userMap.map)

}
