package collections

object TransformingCollectionUsingFlatMap extends App {

  val nestedList = List(List(1, 2, 3, 4), List(4, 5, 6, 7))
  println(nestedList)


  println(nestedList.map(aList => aList.map(_ + 1)))
  println(nestedList.map(aList => aList.map(_ + 1)).flatten)


  println(nestedList.flatMap(aList => aList.map(_ + 1)))


  val list = List("aaa", "bbb")
  println(list.flatMap(s => s))

}
