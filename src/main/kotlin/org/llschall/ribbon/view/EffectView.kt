package org.llschall.ribbon.view

import org.llschall.ribbon.model.AppModel
import java.awt.FlowLayout
import javax.swing.JButton
import javax.swing.JPanel

class EffectView(model: AppModel) : JPanel(FlowLayout(FlowLayout.CENTER)) {

    init {
        val startBtn = JButton("Start Effect")
        add(startBtn)
        startBtn.addActionListener {
            // Activates the special effect.
            model.ribbon.startEffect()
            // Sends the previous activation to the Arduino board.
            model.ribbon.publish()
        }
    }
}
