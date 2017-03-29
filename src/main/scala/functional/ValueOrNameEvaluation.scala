package functional

object ValueOrNameEvaluation {
  def loop():Int = loop;

  def testByValue(x:Int, y:Int)  = x;
  def testByName(x:Int, y: =>Int) = x;

  testByValue(1,2);
  //testByValue(1, loop);//Loop
  testByName(1,3);
  testByName(1, loop); //
}
