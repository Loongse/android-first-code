# kotlin协程

## 基础

本质上，协程是轻量级的线程，他们在某些CoroutineScope（协程范围） 上下文中与launch协程构建器一起启动。在GlobalScope中启动一个新的协程 意味着新协程的生命周期只受整个应用程序的生命周期限制。

delay是一个特殊的挂起函数，不会造成线程阻塞，但是会挂起协程，并且只能在协程中使用。

### 桥接阻塞与非阻塞

显示的使用

```kotlin
//使用runBlocking阻塞主线程
fun main() {
    GlobalScope.launch {
        //后台启动一个协程并继续
        delay(1000L)
        println("World!")
    }
    println("Hello,")//主线程中的代码会立即执行
    runBlocking { //阻塞主线程
        delay(2000L)//延迟以保证JVM的存活
    }
//    结果：
//    Hello,
//    World!
}
```

上述的写法可以将main函数放置于runBlocking中：

```kotlin

//使用runBlocking阻塞主线程,使用runBlocking包装main函数
//kotlin中的main函数需要返回Unit类型
fun main() = runBlocking<Unit> {
    GlobalScope.launch {
        //后台启动一个协程并继续
        delay(1000L)
        println("World!")
    }
    println("Hello,")//主线程中的代码会立即执行
    delay(2000L)//延迟以保证JVM的存活

//    结果：
//    Hello,
//    World!
}
```

使用job.join方法等待协程执行结束而不需要通过其他线程进行阻塞等待
(见basic04.kt)

### 结构化的并发

在执行操作指定的作用域内部启动协程而不是使用Global与应用程序生命周期进行绑定， （使用Global.launch会创建一个顶层协程，虽然这样的协程很轻量但是运行时依然会 消耗一些内存资源，如果忘记保持对新启动的协程的引用，就
会继续运行。如果协程中的代码挂起，容易出错）这时候可以使用结构化并发，会将协程构造器添加到代码块 所在的作用域中。外部协程直到作用域内启动的所有协程都执行完毕才会结束：

```kotlin
fun main() = runBlocking<Unit> {
    launch {
        delay(1000L)
        println("World!")
    }
    println("Hello,")
}
```
### 作用域构建器
使用coroutineScope构建器声明自己的作用域，会构建一个协程作用域并且在所有已启动子协程执行完毕前不会结束。

runBlocking 与 coroutineScope 可能看起来很类似，因为它们都会等待其协程体以及所有⼦协程结束。 主要区别在
于，runBlocking ⽅法会阻塞当前线程来等待，而coroutineScope 只是挂起，会释放底层线程⽤于其他⽤途。 由于存
在这点差异，runBlocking 是常规函数，而coroutineScope 是挂起函数。
### 挂起函数
```kotlin
fun main()= runBlocking {
 launch { 
     doWorld()
 }   
    println("Hello,")
}
//使用挂起函数
//在协程内部也可以正常使用挂起函数，而且挂起函数内部可以使用其他挂起函数比如delay
suspend fun doWorld() {
    delay(1000L)
    println("World!")
}
```
## 取消与超时

## 组合挂起函数

## 协程上下文与调度器

## 异步流

## 通道

## 异常处理

## 共享的可变状态与并发

## select表达式