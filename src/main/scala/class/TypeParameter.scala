package `class`

/**
  * Type erasure (Java, Scala, Hashell, ML, OCamel
  * Keep runtime type: C/C++
  *
  *
  */
class TypeParameter {
}

trait List[T] {
    def isEmpty: Boolean
    def head: T
    def tail: List[T]
}

/**
  * val(private), var(public) no ...(private
  *
  */
class Cons[T](val head: T, val tail: List[T]) extends List[T] {
   def isEmpty = false
}

class Nil[T] extends List[T] {
  def isEmpty = true
  def head:Nothing = throw new NoSuchElementException("Nil.head")
  def tail:Nothing = throw new NoSuchElementException("Nil.tail")
  def singleton(elem: T) = new Cons[T](elem, new Nil[T])
}

