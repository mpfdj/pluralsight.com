package collections


// https://medium.com/@mallikakulkarni/functional-programming-in-scala-2-the-map-function-f9b9ee17d495

object TransformingCollectionUsingMap extends App {

  val event1 = Event("US", "Sun", 10, "Twitter")
  val event2 = Event("China", "Mon", 15, "WeChat")
  val event3 = Event("New Zealand", "Sun", 30, "Twitter")
  val event4 = Event("US", "Tue", 5, "Facebook")
  val event5 = Event("US", "Thu", 24, "LinkedIn")
  val event6 = Event("US", "Sat", 60, "Facebook")
  val events = List(event1, event2, event3, event4, event5, event6)

  val locations = events.map(event => event.location)
  println(locations)

  val locations2 = events.map(_.location) // Short notation
  println(locations2)

  val sources = events.map(_.source)
  println(sources)

  val days = events.map(_.dayOfWeek)
  println(days)



  val set = Set(1, 2, 3)
  println(set.map(i => i))

  val map = Map(1 -> "AAA", 2 -> "BBB", 3 -> "CCC")
  println(map.map(kv => kv))
}


case class Event(location: String, dayOfWeek: String, sessionTimeInSeconds: Int, source: String)