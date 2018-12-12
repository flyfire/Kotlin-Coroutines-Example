package async

import basic.BaseContinuationV1
import common.HttpException
import common.HttpService
import common.log
import java.lang.Exception
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.startCoroutine
import kotlin.coroutines.suspendCoroutine

/**
 * Created by houruhou on 2018/12/12.
 * Desc:
 */
fun 开始协程V2(block: suspend () -> Unit) {
    block.startCoroutine(ContextContinuation(AsyncContext()))
}

suspend fun 开始异步加载图片V2(url: String): ByteArray = suspendCoroutine { continuation ->
    log("异步任务开始前V2")
    AsyncTask {
        try {
            log("耗时操作开始，下载图片V2")
            val response = HttpService.service.getLogo(url).execute()
            if (response.isSuccessful) {
                response.body()?.byteStream()?.readBytes()?.let(continuation::resume)
            } else {
                continuation.resumeWithException(HttpException(response.code()))
            }
        } catch (e: Exception) {
            continuation.resumeWithException(e)
        }
    }.execute()
}