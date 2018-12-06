package basic

import common.HttpException
import common.HttpService
import common.log
import java.lang.Exception
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.startCoroutine
import kotlin.coroutines.suspendCoroutine

/**
 * Created by houruhou on 2018/12/6.
 * Desc:
 */
fun 我要开始协程拉(block: suspend ()->Unit) {
    block.startCoroutine(BaseContinuation())
}

suspend fun 我要开始加载图片啦(url: String): ByteArray = suspendCoroutine {
    continuation ->
    log("耗时操作开始，下载图片")
    try {
        val response = HttpService.service.getLogo(url).execute()
        if (response.isSuccessful) {
            response.body()?.byteStream().readBytes().let(continuation::resume)
        } else {
            continuation.resumeWithException(HttpException(response.code()))
        }
    } catch (e: Exception) {
        continuation.resumeWithException(e)
    }
}