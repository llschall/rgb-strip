package org.llschall.ribbon.view

import org.llschall.ribbon.model.AppModel
import java.awt.BorderLayout
import javax.swing.JCheckBox
import javax.swing.JColorChooser
import javax.swing.JLabel
import javax.swing.JPanel

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
        // add a line of 9 checks representing the first 9 LEDs
        val ledPnl = JPanel()
        for (i in 0 until 9) {
            val check = JCheckBox("$i")
            check.isSelected = true
            model.active.add(i)
            check.addActionListener {
                if (check.isSelected) {
                    model.active.add(i)
                } else {
                    model.active.remove(i)
                }
            }
            ledPnl.add(check)
        }

        add(sliderPnl, BorderLayout.NORTH)
        add(ledPnl, BorderLayout.CENTER)
        add(label, BorderLayout.SOUTH)
    }

    init {
        add(colorChooser, BorderLayout.NORTH)
        add(controlPnl, BorderLayout.CENTER)
        // Updates the overall brightness of the LED strip.
        model.ribbon.setBrightness(slider.value)

        slider.addChangeListener {
            // Updates the overall brightness of the LED strip.
            model.ribbon.setBrightness(slider.value)
            // Sends the previously set brightness to the Arduino board.
            model.ribbon.publish()
        }
    }
}
