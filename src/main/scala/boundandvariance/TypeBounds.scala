package boundandvariance


/**
  * Type Bound:
  */
class TypeBounds {
  //upbound
  def assertAllPos(S <: IntSet)(r:S):S

  //lower bounds
  def assertAllPos(S >: EmptySet)(r:S):S

  //mix bound
  def assertAllPos(S >: EmptySet <: IntSet)(r:S):S
}
