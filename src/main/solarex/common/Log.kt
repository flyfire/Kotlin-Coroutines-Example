package common

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by houruhou on 2018/12/6.
 * Desc:
 */
val dateFormat = SimpleDateFormat("HH:mm:ss:SSS")

val now = {
    dateFormat.format(Date())
}

fun log(msg: String) = println("${now()}--${Thread.currentThread().name}--> $msg")