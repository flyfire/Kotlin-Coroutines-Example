package async

import common.HttpError
import common.HttpException
import common.HttpService
import common.log
import java.lang.Exception
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * Created by houruhou on 2018/12/12.
 * Desc:
 */
suspend fun <T> 开始耗时操作(block: () -> T) = suspendCoroutine<T> { continuation ->
    AsyncTask {
        try {
            continuation.resume(block())
        } catch (e: Exception) {
            continuation.resumeWithException(e)
        }
    }.execute()
}

fun 普通加载图片(url: String): ByteArray {
    log("普通函数，开始加载图片")
    val response = HttpService.service.getLogo(url).execute()
    if (response.isSuccessful) {
        response.body()?.byteStream()?.readBytes()?.let {
            return it
        }
        throw HttpException(HttpError.HTTP_ERROR_NO_DATA)
    } else {
        throw HttpException(response.code())
    }
}