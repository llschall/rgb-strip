package org.llschall.ribbon.model

import org.llschall.rgbribbon.RgbRibbon
import org.llschall.rgbribbon.Status

class AppModel {
    var version: String = ""
    var active: MutableSet<Int> = mutableSetOf()
    var ribbon: RgbRibbon = RgbRibbon(55)
    var status = Status.INIT
}
