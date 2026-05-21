package org.llschall.ribbon.model

import org.llschall.rgb.ribbon.RgbRibbon
import org.llschall.rgb.ribbon.Status

class AppModel {
    var version: String = ""
    var active: MutableSet<Int> = mutableSetOf()

    // This RgbRibbon instance controls the RGB ribbon or LED strip via the Arduino board.
    var ribbon: RgbRibbon = RgbRibbon()
    var status = Status.INIT
}
