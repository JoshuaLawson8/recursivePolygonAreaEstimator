package mvc

import tools._

trait Model(var unsavedChanges: Boolean = false, var filename: String = "") extends Bean:
  def setChanges(b: Boolean): Unit =
    unsavedChanges = b

  def setFileName(s: String): Unit =
    filename = s

  def changed(): Unit =
    unsavedChanges = true
    println("changed")