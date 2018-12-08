package async

import java.util.concurrent.Executors

/**
 * Created by houruhou on 2018/12/8.
 * Desc:
 */
private val pool by lazy {
    Executors.newCachedThreadPool()
}
class AsyncTask(val block: () -> Unit) {
    fun execute() = pool.execute(block)
}