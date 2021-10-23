object MatchOnConstants extends App {

  //  val number = 5
  val number = 99

  val numberString = number match {
    case 0 => "zero"
    case 5 => "five"
    case 9 => "nine"
    case _ => "nothing matched"
  }


  println(numberString)
}
