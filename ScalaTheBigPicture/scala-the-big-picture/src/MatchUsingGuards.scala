object MatchUsingGuards extends App {

  val importantPeople = Set("wife@home.com", "boss@office.com")
  val importantEmail = Email("boss@office.com", "We need to talk!")
  val regularEmail = Email("marketing@google.com", "Read our transparency report")


  // Function
  def alertOrNoAlert(email: Email) = email match {
    case Email(from, _) if importantPeople.contains(from) => println("This email needs your attention")  // The pattern guard is a predicate (works like a filter)
    case _ => println("Do not disturb.")
  }


  alertOrNoAlert(regularEmail)
  alertOrNoAlert(importantEmail)

}


  case class Email(from: String, body: String)