object Conditionals extends App {
  val arguments = List("Monday");
  val day = if (!arguments.isEmpty) arguments(0) else "Sunday"

  println(arguments)
  println(day)
}
