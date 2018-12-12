package async

import common.HttpError
import common.HttpException
import common.HttpService
import common.log
import java.lang.Exception
import kotlin.coroutines.*

/**
 * Created by houruhou on 2018/12/12.
 * Desc:
 */
fun 开始协程V4(context: CoroutineContext = EmptyCoroutineContext, block: suspend ()->Unit) {
    block.startCoroutine(ContextContinuation(context + AsyncContext()))
}
suspend fun <T> 开始耗时操作V4(block: CoroutineContext.() -> T) = suspendCoroutine<T> { continuation ->
    AsyncTask {
        try {
            continuation.resume(block(continuation.context))
        } catch (e: Exception) {
            continuation.resumeWithException(e)
        }
    }.execute()
}
