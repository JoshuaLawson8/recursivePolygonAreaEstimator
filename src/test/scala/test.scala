
import model._
import mvc._

@main def test(): Unit =
  val y = List((0.0,0.0),(1.0,0.0),(1.0,1.0),(0.0,1.0))
  val x = Polygon(y)
  println(x.getArea)
  val z = Grid()
  