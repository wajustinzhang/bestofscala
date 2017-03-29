package functional

/**
  * this is the function A: => B definition
  *
  * eta-expansion
  */
trait Function1[A,B] {
  def apply(x: A): B
}
