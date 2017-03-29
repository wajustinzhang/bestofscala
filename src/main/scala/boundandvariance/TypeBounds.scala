package boundandvariance


/**
  * Type Bound:
  *
  * Relationship between Type bound and covariance:
  *
  * Liskov Substitution Principle
  *
  * Generally, if A2 <:A1, and B1<:B2 then
  *    A1 => B1 <: A2 => B2
  * which means functions are contravariant in their argument types and covariant in the result type. In scala, roughly:
  * 1: covariant type parameters can only appear in function result, it may appear in lower bounds of function type parameter
  * 2: contravariant type parameters can only appear in method parameters, may appear in upper bounds of method.
  * 3: invariant type parameter can appear anywhere.
  */
abstract class TAbstractSet
class CustomSet extends TAbstractSet

abstract class TypeBounds {
  //upbound
  def assertAllPos[S <: TAbstractSet](r:S):S

  //lower bounds
  def assertAllPos[S >: CustomSet](r:S):S

  //mix bound
  def assertAllPos[S >: CustomSet <: TAbstractSet](r:S):S
}

//definition of function, T is contravariant, and U is covariant.
trait Function1[-T, +U] {
  def apply(x:T) : U
}

trait List[+T] {
  def head: T
  def prepend[U >: T] (element:U): List[U] = new Cons(element, this)
}

class Cons[T](element: T, list: List[T]) extends List[T]{
  override def head: T = ...
}

object Nil extends List[Nothing] {
  def head:Nothing = throw new NoSuchElementException("test")
}
object testList {
  var x: List[String] = Nil //The list type should be covariant to make this assignment correct.
}