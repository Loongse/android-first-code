package coroutineslearing

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    //协程很轻量
    repeat(100_000) {
        //启动大量协程
        launch {
            delay(5000L)
            print(".")
        }
    }
}