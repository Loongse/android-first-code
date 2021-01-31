package coroutineslearing

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    GlobalScope.launch {//后台启动一个新的协程并继续
        delay(1000L)//非阻塞等待一秒钟
        println("World!")//延迟后打印输出
    }
    println("Hello,")//协程已在等待时主线程还在继续
    Thread.sleep(2000L)//阻塞主线程2秒钟保证JVM存活
    //运行结果
    /**
     * Hello,
     * World!
     */

}