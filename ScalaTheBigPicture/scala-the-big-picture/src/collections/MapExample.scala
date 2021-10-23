package collections

object MapExample extends App {

  val weekDays = Map(1 -> "Sunday", 2 -> "Monday", 3 -> "Tuesday")

  println(weekDays(3))
  println(weekDays + (4 -> "Wednesday"))
  println(weekDays - 2)
  println(weekDays)

  // entry is a tuple in this example it represents (String, Int), which is shorthand for Tuple2[String, Int]
  weekDays.foreach(entry => println(s"${entry._1} => ${entry._2}"))

  val tuple = (10, 20, 30)
  println(tuple._1)
  println(tuple._2)
  println(tuple._3)


  println(weekDays ++ Map(4-> "Wednesday", 5 -> "Thursday"))

  println(weekDays.min)
}
