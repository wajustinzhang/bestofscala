package patternmatch

/**
  * Problem with Class hierarchy, too many method implementation! O(n^2).
  * 
  * OO decomposition is not always work, need to touch all classes to add a new method.
  * 1: Classification and access methods: O(n^2) explosition
  * 2: Type cast /test unsafe
  *
  * Best solution. Pattern matching
  *   The sole purpose of test/accessor functions is to reverse the construction process.
  *
  *   "case class"  -- implicitly defines companion objects with apply methods.
  *
  * Use pattern matching reduce adding method in sub-classes repeatly.
  */
class Decomposition {

}

trait Expr {
  //classification
  def isNumber: Boolean
  def isSum: Boolean
  
  //accessor
  def numValue: Int
  def leftOpr: Expr
  def rightOpr: Expr
  
  //def eval(e:Expr):Int

  //use pattern matching to implement the eval:
  def eval:Int = this match {
    case Number(n) => n
    case Sum(e1, e2) => e1.eval + e2.eval
  }
}

//Case function
case class Number(x:Int) extends Expr{
  override def isNumber: Boolean = true
  override def isSum: Boolean = false
  override def numValue: Int = x
  override def leftOpr: Expr = throw new Error("Number.leftOp")
  override def rightOpr: Expr = throw new Error("Number.rightOp")
}

case case class Sum(left: Expr, right: Expr) extends Expr {
  override def isNumber: Boolean = false
  override def isSum: Boolean = true
  override def numValue: Int = throw new Error("Sum.numValue")
  override def leftOpr: Expr = left
  override def rightOpr: Expr = right
}

case class Prod(e1: Expr, e2: Expr) extends Expr{
  override def isNumber: Boolean = ???
  override def isSum: Boolean = ???
  override def numValue: Int = ???
  override def leftOpr: Expr = ???
  override def rightOpr: Expr = ???
}

case class Var(x: String) extends Expr {
  override def isNumber: Boolean = ???
  override def isSum: Boolean = ???
  override def numValue: Int = ???
  override def leftOpr: Expr = ???
  override def rightOpr: Expr = ???
}

