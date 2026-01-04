package org.llschall.ribbon.view

import org.llschall.ribbon.model.AppModel
import org.llschall.ribbon.controller.AppController
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.SwingUtilities
import java.awt.BorderLayout
import javax.swing.JColorChooser
import javax.swing.JTabbedPane
import kotlin.system.exitProcess

class MainPanel(private val model: AppModel, private val controller: AppController) : JPanel(BorderLayout()) {
    val label = JLabel("Featuring rgb-ribbon " + model.version, JLabel.CENTER)
    private val startButton = JButton("Start")
    private val toggleLedButton = JButton("Toggle built-in LED")
    private val colorChooser = JColorChooser(background).apply {
        previewPanel = JPanel() // Remove the color preview
    }
    private val buttonPanel = JPanel()
    private val exitButton = JButton("Exit")
    private val tabbedPane = JTabbedPane(JTabbedPane.LEFT)

    init {
        startButton.addActionListener { controller.start() }
        colorChooser.selectionModel.addChangeListener {
            val c = colorChooser.color
            background = c // Set the panel background to the chosen color

            for (i in 0 until 9) {
                if (model.active.contains(i)) {
                    model.ribbon.getLed(i).setColor(c)
                }
            }
            model.ribbon.publish()
        }
        toggleLedButton.addActionListener {
            controller.toggleBuiltInLed()
        }
        exitButton.addActionListener { exitProcess(0) }
        buttonPanel.add(startButton)
        buttonPanel.add(toggleLedButton)
        buttonPanel.add(exitButton)
        // Setup Connect tab
        tabbedPane.addTab("Connect", ConnectView(label, colorChooser, model))
        tabbedPane.addTab("Effect", EffectView(model))

        // Setup About tab
        tabbedPane.addTab("About", AboutView())
        // Add the tabbedPane to the center
        add(tabbedPane, BorderLayout.CENTER)
        // Always add the button panel to the SOUTH
        add(buttonPanel, BorderLayout.SOUTH)
    }
}

class AppView(private val model: AppModel, private val controller: AppController) {

    val panel = MainPanel(model, controller)

    fun show() {

        SwingUtilities.invokeLater {
            val frame = JFrame("rgb-ribbon demo ")
            frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
            frame.setSize(600, 500) // Changed width to 600, height remains 500
            frame.add(panel)
            frame.setLocationRelativeTo(null)
            frame.isVisible = true
            frame.rootPane.registerKeyboardAction(
                { frame.dispose() },
                javax.swing.KeyStroke.getKeyStroke("ESCAPE"),
                javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW
            )
            frame.rootPane.registerKeyboardAction(
                { controller.start() },
                javax.swing.KeyStroke.getKeyStroke("SPACE"),
                javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW
            )
        }
    }

    fun update() {
        SwingUtilities.invokeLater {
            panel.label.text = model.status.name
        }
    }
}
