package async

import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

/**
 * Created by houruhou on 2018/12/12.
 * Desc:
 */
class ContextContinuation(override val context: CoroutineContext = EmptyCoroutineContext): Continuation<Unit> {
    override fun resumeWith(result: Result<Unit>) {

    }

}