package oo

/**
  * Created by WAZHANG-DEV on 2/23/2017.
  */
class ErrorMessage {
  def getErrorMessage(code:Int):String = {
     var result = code match {
       case 1=> "test1"
       case 2=> "test2"
       case 3=> "test3"
     }

     return result;
  }
}
