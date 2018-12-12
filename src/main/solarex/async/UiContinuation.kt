package async

import javax.swing.SwingUtilities
import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException


/**
 * Created by houruhou on 2018/12/9.
 * Desc:
 */
class UiContinuationWrapper<T>(val continuation: Continuation<T>) : Continuation<T>{
    override fun resumeWith(result: Result<T>) {
        SwingUtilities.invokeLater{
            if (result.isSuccess) {
                continuation.resume(result.getOrNull() as T)
            } else {
                continuation.resumeWithException(result.exceptionOrNull()!!)
            }
        }
    }

    override val context: CoroutineContext
        get() = continuation.context

}