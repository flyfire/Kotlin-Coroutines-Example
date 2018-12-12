package async

import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext

/**
 * Created by houruhou on 2018/12/12.
 * Desc:
 */
class DownloadContext(val url: String): AbstractCoroutineContextElement(SolarexKey) {
    companion object SolarexKey: CoroutineContext.Key<DownloadContext>
}