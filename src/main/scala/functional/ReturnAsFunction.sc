object ReturnAsFunction {
  def averageDamp (f:Double=>Double)(x:Double) = (x+f(x))/2

}