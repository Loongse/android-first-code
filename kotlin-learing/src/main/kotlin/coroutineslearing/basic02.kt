package coroutineslearing

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

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