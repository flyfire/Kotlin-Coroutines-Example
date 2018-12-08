package ui

import basic.我要开始加载图片啦
import basic.我要开始协程拉
import common.log
import javax.swing.JFrame.EXIT_ON_CLOSE

/**
 * Created by houruhou on 2018/12/8.
 * Desc:
 */
const val AVASTAR_URL = "https://avatars1.githubusercontent.com/u/922231?s=400&v=4"

fun main(args: Array<String>) {
    val frame = MainWindow()
    frame.title = "Solarex"
    frame.setSize(150, 150)
    frame.isResizable = true
    frame.defaultCloseOperation = EXIT_ON_CLOSE
    frame.init()
    frame.isVisible = true

    frame.onButtonClick {
        log("协程之前")
        我要开始协程拉 {
            log("协程内部")
            val imageData = 我要开始加载图片啦(AVASTAR_URL)
            frame.setLogo(imageData)
        }
    }
}