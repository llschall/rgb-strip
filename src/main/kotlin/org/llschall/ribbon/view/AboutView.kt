package org.llschall.ribbon.view

import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JTextArea
import java.awt.BorderLayout

class AboutView : JPanel(BorderLayout()) {
    init {
        val url = "https://github.com/llschall/rgb-ribbon-demo"
        val titleLabel = JLabel("About: RGB Ribbon Demo", JLabel.CENTER)

        val urlTextArea = JTextArea(url).apply {
            isEditable = false
            wrapStyleWord = true
            lineWrap = true
            rows = 2
        }

        val containerPnl = JPanel(BorderLayout()).apply {
            add(titleLabel, BorderLayout.NORTH)
            add(urlTextArea, BorderLayout.CENTER)
        }

        add(containerPnl, BorderLayout.CENTER)
    }
}
