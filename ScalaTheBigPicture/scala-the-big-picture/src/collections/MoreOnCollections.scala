package collections

// Filtering, Size and Conversion operations on Collections

object MoreOnCollections extends App {


  // Filtering
  val pageLoadTimesInSeconds = List(2, 1, 5, 9, 14, 22, 45, 2, 4, 23)

  println(pageLoadTimesInSeconds.filter(seconds => seconds >= 10))
  println(pageLoadTimesInSeconds.filter(_ >= 10)) // Short notation
  println(pageLoadTimesInSeconds.filter(_ >= 10).min)
  println(pageLoadTimesInSeconds.filter(_ >= 10).max)


  // Size
  val list = List(4, 3, 2, 1)
  val set = Set(4, 3, 2, 1)
  val map = Map(1 -> "Sunday", 2 -> "Monday")

  println(list.isEmpty)
  println(list.nonEmpty)
  println(set.isEmpty)
  println(set.nonEmpty)
  println(map.isEmpty)
  println(map.nonEmpty)


  // Conversion
  println(list.toSet)
  println(set.toList)



}
