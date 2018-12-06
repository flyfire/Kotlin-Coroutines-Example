package common

import java.lang.Exception

/**
 * Created by houruhou on 2018/12/6.
 * Desc:
 */
object HttpError {
    const val HTTP_ERROR_NO_DATA = 111
    const val HTTP_ERROR_UNKNOWN = 222
}

data class HttpException(val code: Int): Exception()