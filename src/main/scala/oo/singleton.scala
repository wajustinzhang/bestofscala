package oo

/**
  * Created by WAZHANG-DEV on 2/23/2017.
  */
class Singleton private(var name:String) {
   var _name = name;
   def foo() = {print(_name)}
}

object Singleton {
  def apply(name:String) = new Singleton(name)
}

object test1 extends App {
  var s = Singleton("test");
  s.foo();
}