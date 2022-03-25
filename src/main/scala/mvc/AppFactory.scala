package mvc

trait AppFactory:
    def makeModel(): Model
    def makeView(): View
    def getTitle: String
    def getHelp: List[String]
    def about(): String
    def getEditCommands: List[String]
    def makeEditCommand(m: Model, name: String, source: Any): Unit
