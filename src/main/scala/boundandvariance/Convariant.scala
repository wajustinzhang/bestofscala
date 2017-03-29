package boundandvariance

/**
  * Scala Array is not covariant, contrast to Java. In Java array is covariant, generics not. In Scala, both are not.
  *
  * Roughly A type with mutable values shouldn't be covariant, immutable types can be if some condition on methods are met.
  *
  * Three types
  * Convariant  class C[+A]
  * Contravariant
  * nonVariant
  */
object Convariant {
  var T = new Test
  var X = T.ascent(new NonEmpty)
  var Y = T.descent(new Empty)

}

class IntSet
class NonEmpty extends IntSet
class Empty extends IntSet
class Test {
  def descent(x: IntSet): NonEmpty = new NonEmpty
  def ascent(x: NonEmpty):IntSet = new Empty
}


