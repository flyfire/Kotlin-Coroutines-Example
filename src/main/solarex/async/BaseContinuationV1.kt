package basic

import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

/**
 * Created by houruhou on 2018/12/6.
 * Desc:
 */
class BaseContinuationV1: Continuation<Unit> {
    override val context: CoroutineContext
        get() = EmptyCoroutineContext

    override fun resumeWith(result: Result<Unit>) {

    }
}