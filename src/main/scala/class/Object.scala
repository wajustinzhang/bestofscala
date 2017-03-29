package `class`

class Object {
   def main(args: Array[String]) = Empty
}
/**
  *  persistent data structure
  *
  *  override (override is mandatory, strong type GOOD) & implement
  *
  *  dynamic method dispatch is analogous to calls to high-order functions.
  */
abstract class InitSet {
  def include(x:Int): InitSet
  def contains(x:Int):Boolean
  def union(that:InitSet):InitSet
  def intersect(that: InitSet): InitSet
}

object Empty extends InitSet {
  override def include(x: Int): InitSet = new NonEmpty(x, Empty, Empty)
  override def contains(x: Int): Boolean = false
  override def union(that: InitSet): InitSet = that
}

class NonEmpty(elem:Int, left: InitSet, right:InitSet) extends InitSet {
  override def include(x: Int): InitSet =
    if (x<elem) new NonEmpty(elem, left include x, right)
    else if(x>elem) new NonEmpty(elem, left, right include x )
    else this

  override def contains(x: Int): Boolean =
    if(x < elem) left contains x
    else if (x > elem) right contains x
    else true

  override def toString: String = "{" + left + elem + right + "}"

  override def union(that: InitSet): InitSet = (left union right) union that include elem

  override def intersect(that: InitSet): InitSet = ???
}