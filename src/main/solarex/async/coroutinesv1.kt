@file:JvmName("v1")
package basic

import async.AsyncTask
import async.UiContinuationWrapper
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
fun 开始协程V1(block: suspend () -> Unit) {
    block.startCoroutine(BaseContinuationV1())
}

suspend fun 开始异步加载图片V1(url: String): ByteArray = suspendCoroutine { continuation ->
    log("异步任务开始前V1")
    AsyncTask {
        val uiContinuationV1 = UiContinuationWrapper(continuation)
        try {
            log("耗时操作开始，下载图片V1")
            val response = HttpService.service.getLogo(url).execute()
            if (response.isSuccessful) {
                response.body()?.byteStream()?.readBytes()?.let(uiContinuationV1::resume)
            } else {
                uiContinuationV1.resumeWithException(HttpException(response.code()))
            }
        } catch (e: Exception) {
            uiContinuationV1.resumeWithException(e)
        }
    }.execute()
}