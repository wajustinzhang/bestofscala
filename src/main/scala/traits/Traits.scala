/**
  * Traits have no parameters like class. It is similiar to interface with default implementation in JDK1.8
  */
object testTrait{
  var s = new Square();
  s.error("test")
}

trait Color {}
trait Movable{
}
trait Except {
  def error(msg:String) = throw  new Error(msg)
}

abstract class Shape
class Square extends Shape with Color with Movable with Except


