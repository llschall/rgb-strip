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
        model.ribbon.start()
    }

    fun toggleBuiltInLed() {
        model.ribbon.toggleBuiltInLed()
    }

    fun onStatusChanged(status: Status) {
        model.status = status
        view!!.update();
    }

}
