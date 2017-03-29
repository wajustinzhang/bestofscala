/** Cons-List are linked list.
  *
  */

object testConsList {
  Nil
}

trait InitList
class Cons(val head: Int, val tail: InitList) extends InitList
class Nil extends InitList