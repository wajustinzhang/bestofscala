object HighOrderFunction {
  //anonymous function
  (x:Int, y:Int) => x+y

  //anonymous function with f
  def f()(x:Int, y:Int) = x+y

  //high order function
  def sum(f: Int =>Int)(a: Int, b: Int) :Int = {
    def loop(a:Int, acc:Int): Int = {
      if(a>b) acc else loop(a+1, f(a) + acc)
    }

    loop(a, 0)
  }

  sum(x=>x*x)(3, 5)

  //steps:
     //sum(x=>x*x)(3,5)
     //loop(3,0)
     //if(3>5) 0 else loop(4, f(3) + 0)
     //loop(4, 3*3)
     //loop(4,9)
     //if(4>5) 9 else loop(5, f(4) + 9)
     //loop(5, 4*4 + 9)
     //loop(6, 25)
}