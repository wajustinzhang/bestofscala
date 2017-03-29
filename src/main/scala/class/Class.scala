package `class`

/**
  * Class is mainly for define "type"
  * method is implement as pure function
  * state is immutable
  *
  * require: enforce a precondition on the caller of a function
  * assert: check the code of the function itself
  *
  * scala has implicit constructor to execute variable definition in the class.  can define another one.
  *
  * Class and substitutions
  *
  * new C(v1,v2,..., vm).f(w1,w2,...wn) : substitution steps.
  * [w1/y1,w2/y2,...wn/yn][v1/x1,v2/x2,...vm/xm][new c(x1,...xm)/this]b
  *
  */
class Class(x:Int, y:Int) {
  require(y != 0, "denominate must be non-zero")

  private def gcd(a:Int, b:Int):Int = if (b ==0) a else gcd(b, a%b)
  private def g = gcd(x,y)
  /*
   * 1: if x/gcd(x,y). Then it will be problem if numer and denom are called frequently.
   * 2: change to var: will only compute once., when numer and denom are called frequently.
   */
  def numer = x/g
  def denom = y/g

  def this(x:Int) = this(x, 1) //can define additional constructor

  def + (that: Class) = new Class(this.numer*that.numer + that.numer*this.denom, this.denom*that.denom)//self reference
  def unary_-  = new Class(-numer, -denom) //define a unary operator
  def -(that:Class) = this + -that

  def <(that:Class) = numer * that.denom < that.numer*denom
  def >(that:Class) = if(this < that) that else this //self reference

  override def toString: String = this.numer/g + "/" + this.denom/g
}
