package mvc

trait Model(var unsavedChanges: Boolean = false, var filename: String = ""): //extends Bean
  def setChanges(b: Boolean) =
    unsavedChanges = b
  def setFileName(s: String) =
    filename = s
  def changed() =
    unsavedChanges = true
    println("changed")