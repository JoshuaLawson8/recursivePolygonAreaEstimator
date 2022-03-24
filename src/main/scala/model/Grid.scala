package model

import mvc._

class Grid extends Model():
  val y = List((0.0,0.0),(1.0,0.0),(1.0,1.0),(0.0,1.0))
  var curPoly = Polygon(y)
  

