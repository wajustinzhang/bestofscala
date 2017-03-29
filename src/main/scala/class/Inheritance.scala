package `class`

/**
  * Definition of inheritance
  */
object Inheritance {
   var s1 = new NonEmpty(3, new Empty, new Empty)
   s1 include 4
   s1 include 5
}

/**
  *  persistent data structure
  *
  *  override (override is mandatory, strong type GOOD) & implement
  *
  *  dynamic loading
  */


/*
  chang class --> object singleton.
 */
abstract class InitSet {
    def include(x:Int): InitSet
    def contains(x:Int):Boolean
}

class Empty extends InitSet {
  override def include(x: Int): InitSet = new NonEmpty(x, new Empty, new Empty)
  override def contains(x: Int): Boolean = false
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
}