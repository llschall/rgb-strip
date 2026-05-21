import org.llschall.ribbon.controller.AppController
import org.llschall.ribbon.model.AppModel
import org.llschall.ribbon.view.AppView

fun main() {
    val model = AppModel()
    val controller = AppController(model)
    controller.loadVersion()
    // Enables to track the status of the connection with the Arduino board.
    model.ribbon.addStatusListener(controller::onStatusChanged)
    val view = AppView(model, controller)
    controller.view = view
    view.show()
}
