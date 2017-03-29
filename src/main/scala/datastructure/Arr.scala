/**
  * Created by WAZHANG-DEV on 2/23/2017.
  */

object Arr extends App {
  //  1: define array
  var a = Array(1,2,3,4)
  var b = new Array[Int](3)

  // assign an array to another
  var x: Seq[Int] = a
  x = x.reverse;
  x.foreach(println)
  println()

  //update array
  b(0) = 1
  b.update(1,10)
  b(2) = 3
  b.foreach(println)
  println()


  //array map
  var c = b.map(x=>2*x)
  c.foreach(println)
  println()

  //array filter
  var e = c.filter(_ > 2)
  e.foreach(println)
  println()

  var d = c.filter(x=>x>10)
  d.foreach(println)
  println()

  //loop array
  for(x<-d) print(x)
}