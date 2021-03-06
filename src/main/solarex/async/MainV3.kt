package async

import basic.开始协程V1
import basic.开始异步加载图片V1
import common.log
import ui.MainWindow
import javax.swing.JFrame.EXIT_ON_CLOSE

/**
 * Created by houruhou on 2018/12/8.
 * Desc:
 */

fun main(args: Array<String>) {
    val frame = MainWindow()
    frame.title = "Solarex"
    frame.setSize(150, 150)
    frame.isResizable = true
    frame.defaultCloseOperation = EXIT_ON_CLOSE
    frame.init()
    frame.isVisible = true

    frame.onButtonClick {
        log("协程之前V3")
        开始协程V2 {
            log("协程内部V3")
            val imageData = 开始耗时操作 {
                普通加载图片(AVASTAR_URL)
            }
            log("获取到图片数据V3")
            frame.setLogo(imageData)
        }
        log("协程外部V3")
    }
}