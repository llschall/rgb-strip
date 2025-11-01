package org.llschall.ribbon.controller

import org.llschall.rgbribbon.RgbRibbon
import org.llschall.rgbribbon.Status
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
