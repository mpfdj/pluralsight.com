package classes


object Person {
  def apply(firstName: String, lastName: String) = new Person(firstName, lastName)
}

class Person(firstName: String, lastName: String) {
  def getName: String = firstName + " " + lastName
}


// case class gets the apply method for free
case class Course(title: String, author: String)