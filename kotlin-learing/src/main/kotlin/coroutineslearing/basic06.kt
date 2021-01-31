package coroutineslearing

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
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
