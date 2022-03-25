package mvc

import javax.swing._
import java.beans._
//
class View(var curModel: Model) extends JPanel with PropertyChangeListener:
  curModel.addPropertyChangeListener(this)

  def setModel(newModel: Model): Unit =
    this.curModel.removePropertyChangeListener(this)
    this.curModel = newModel
    this.curModel.initSupport()
    this.curModel.addPropertyChangeListener(this)

  def propertyChange(propertyChangeEvent: PropertyChangeEvent): Unit =
    repaint()