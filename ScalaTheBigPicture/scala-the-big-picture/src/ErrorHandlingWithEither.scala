object ErrorHandlingWithEither extends App {

  def stringToInt(in: String): Either[String, Int] = {
    try {
      Right(in.toInt)  // Int
    } catch {
      case e: NumberFormatException => Left("Error: " + e.getMessage)  // String
    }
  }


  val fiveToInt = stringToInt("5")
  val helloToInt = stringToInt("hello")

  println(fiveToInt)
  println(helloToInt)




}
