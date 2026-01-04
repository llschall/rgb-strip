package org.llschall.ribbon.model

import org.llschall.rgb.ribbon.RgbRibbon
import org.llschall.rgb.ribbon.Status
import org.llschall.ribbon.view.EffectView
import java.util.concurrent.atomic.AtomicBoolean

class AppModel {
    var version: String = ""
    var active: MutableSet<Int> = mutableSetOf()
    var ribbon: RgbRibbon = RgbRibbon(55)
    var status = Status.INIT
}
