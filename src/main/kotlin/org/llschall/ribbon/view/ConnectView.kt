package org.llschall.ribbon.view

import org.llschall.ribbon.model.AppModel
import javax.swing.JLabel
import javax.swing.JPanel
import java.awt.BorderLayout
import javax.swing.JColorChooser

class ConnectView(
    label: JLabel,
    colorChooser: JColorChooser,
    private val model: AppModel
) : JPanel(BorderLayout()) {

    private val slider = javax.swing.JSlider(0, 255, 55)
    private val brightnessLbl = JLabel("Brightness")
    private val sliderPnl = JPanel(BorderLayout()).apply {
        add(brightnessLbl, BorderLayout.NORTH)
        add(slider, BorderLayout.SOUTH)
    }
    private val controlPnl = JPanel(BorderLayout()).apply {
        add(sliderPnl, BorderLayout.NORTH)
        add(label, BorderLayout.SOUTH)
    }

    init {
        add(colorChooser, BorderLayout.NORTH)
        add(controlPnl, BorderLayout.CENTER)
        model.ribbon.setBrightness(slider.value)

        slider.addChangeListener {
            model.ribbon.setBrightness(slider.value)
            model.ribbon.publish()
        }
    }
}
