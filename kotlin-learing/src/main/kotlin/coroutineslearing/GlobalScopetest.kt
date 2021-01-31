package coroutineslearing

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    //全局协程像守护线程，在GlobalScope中启动
//    的活动协程不会让进程保活，跟守护线程一样
    GlobalScope.launch {
        repeat(1000) { i ->
            println("I am sleeping $i ...")
            delay(500L)
        }
    }
    delay(1300L)

}