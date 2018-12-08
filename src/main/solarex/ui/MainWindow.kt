package ui

import java.awt.BorderLayout
import java.awt.Dimension
import java.awt.event.ActionEvent
import java.util.*
import javax.swing.ImageIcon
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel


/**
 * Created by houruhou on 2018/12/8.
 * Desc:
 */
class MainWindow : JFrame() {
    private lateinit var button: JButton
    private lateinit var image: JLabel

    fun init() {
        button = JButton("Click Me")
        image = JLabel()
        image.size = Dimension(150, 50)

        contentPane.add(button, BorderLayout.NORTH)
        contentPane.add(image, BorderLayout.CENTER)
    }

    fun onButtonClick(listener: (ActionEvent) -> Unit) {
        button.addActionListener(listener)
    }

    fun setLogo(logoData: ByteArray) {
        image.icon = ImageIcon(logoData)
    }
}