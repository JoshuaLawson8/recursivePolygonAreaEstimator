package model

class Polygon(val points: List[(Double,Double)]):
  def getArea: Double =
    var j = points.length-1
    var area = 0.0
    for i <- points.indices do
      area = area + ((points(j)._1 + points(i)._1) * (points(j)._2 - points(i)._2))
      j = i
    if(area < 0)
      -area/2
    else
      area/2






