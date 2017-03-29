//block and visibility (lexical scope)
//inner function (private)
//; is optional
object LexicalScope {
  def sqrt(x:Double) = {
    def improve(guess: Double) = (guess + x/guess) /2

    def abs() = if (x>=0) x else -x
    def isGoodEnough(guess:Double):Boolean = abs()/x < 0.0001

    def sqrtIter(guess: Double):Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))

    sqrtIter(1.0)
  }

  sqrt(3e-20)
  sqrt(3e+20)
}