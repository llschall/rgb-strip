package org.llschall.ribbon.view

import javax.swing.JLabel
import javax.swing.JPanel
import java.awt.BorderLayout
import java.awt.Cursor
import java.awt.Desktop
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.net.URI
import javax.swing.JOptionPane

class AboutView : JPanel(BorderLayout()) {
    init {
        val url = "https://github.com/llschall/rgb-ribbon-demo"
        val label = JLabel("<html>About: RGB Ribbon Demo<br><a href='$url'>$url</a></html>", JLabel.CENTER)
        label.cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)
        label.toolTipText = url
        label.addMouseListener(object : MouseAdapter() {
            override fun mouseClicked(e: MouseEvent?) {
                if (e != null && e.button == MouseEvent.BUTTON1) {
                    try {
                        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(java.awt.Desktop.Action.BROWSE)) {
                            Desktop.getDesktop().browse(URI(url))
                        }
                    } catch (ex: Exception) {
                        JOptionPane.showMessageDialog(label, "Could not open browser: " + ex.message)
                    }
                }
            }
        })
        add(label, BorderLayout.CENTER)
    }
}
