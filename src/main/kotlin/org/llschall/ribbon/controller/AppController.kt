package org.llschall.ribbon.controller

import org.llschall.rgb.ribbon.RgbRibbon
import org.llschall.rgb.ribbon.Status
import org.llschall.ribbon.model.AppModel
import org.llschall.ribbon.view.AppView

class AppController(private val model: AppModel) {

    var view: AppView? = null

    fun loadVersion() {
        model.version = RgbRibbon.VERSION
    }

    fun start() {
        // Initiates the communication with the Arduino board.
        // Will fail if the Arduino board is not connected.
        model.ribbon.start()
    }

    fun toggleBuiltInLed() {
        // Toggles the built-in LED on the Arduino board.
        // Has no impact on the LED strip.
        model.ribbon.toggleBuiltInLed()
    }

    fun onStatusChanged(status: Status) {
        model.status = status
        view!!.update();
    }

}
