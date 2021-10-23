import scala.util.{Failure, Success, Try}

object ErrorHandlingWithTry extends App {

  val outcome = Try(10 / 0);

  println(outcome.isSuccess)
  println(outcome.isFailure)

  // Pattern matching
  outcome match {
    case Success(value) => println("Computation was okay, value is " + value)
    case Failure(e) => println("Computation failed " + e.getMessage)
  }

}
