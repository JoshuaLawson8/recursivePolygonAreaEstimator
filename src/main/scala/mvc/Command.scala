package mvc

trait Command(model: Model):
  def execute(): Unit