import scala.annotation.tailrec

object TailRecursion{
  //Tail Recursion
  @tailrec
  def gcd(a:Int, b:Int):Int =
    if(a==0) 1 else gcd(b, a % b)

  //Non Tail Recursion
  def factorial(a:Int):Int =
     if(a == 0) 1 else a*factorial(a-1);

  // Convert to tail function
  def factorialTail(a:Int):Int = {
     def loop(acc:Int, n: Int):Int = {
       if(n == 0) acc else loop(acc*n, n-1);
     }
     loop(1, a);
  }
}