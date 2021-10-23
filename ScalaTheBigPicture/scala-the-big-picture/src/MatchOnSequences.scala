object MatchOnSequences extends App {

  val numbers = List(1, 2, 3, 4, 5)

  val second = numbers match {
    case List(_, second, _*) => second
    case _ => -1
  }

  println(second)

}
