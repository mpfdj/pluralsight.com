package collections

object OptionAndFlatMap extends App {

  def toInt(s: String): Option[Int] = {
    try {
      Some(s.toInt)
    } catch {
      case e: NumberFormatException => None
    }
  }


  val arguments = List("10", "eight", "5", "four", "3", "20", "one")
  println(arguments.map(toInt(_)))
  println(arguments.map(toInt(_)).flatten.sum)


  println(arguments.flatMap(toInt(_)))
  println(arguments.flatMap(toInt(_)).sum)

}
