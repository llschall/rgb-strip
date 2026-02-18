package org.llschall.ribbon.model

import org.llschall.rgb.ribbon.RgbRibbon
import org.llschall.rgb.ribbon.Status

class AppModel {
    var version: String = ""
    var active: MutableSet<Int> = mutableSetOf()
    var ribbon: RgbRibbon = RgbRibbon()
    var status = Status.INIT
}
