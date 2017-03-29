//curring
//closure

//Multiple Parameter Lists
//In general, a definition of a function with multiple paramater lists
//
//def f(arg1)(arg2)...(argn) = E
//
// where n>1 is equivalent to
//
//==> def f(arg1)(arg2)....(argn-1) = (def g(argn) = E;g})
// or
//==> def f(arg1)(arg2)...(argn-1) = (argn=>E)
// or
//==> def f(arg1=>(arg2=>(arg2=>...(argn=>E)...)   --> Curry
//

object Currying{
  //classic style
  def sum(f: Int => Int):(Int, Int)=>Int = {
    def sumF(a:Int, b:Int): Int =
      if(a>b) 0 else f(a) + sumF(a+1, b)
    sumF
  }

  //scala specific
  def sum1(f: Int => Int)(a: Int, b: Int) :Int =
      if(a>b) 0 else f(a) + sum(f)(a+1, b)

  sum(x=>x*x)(2,5)
}
