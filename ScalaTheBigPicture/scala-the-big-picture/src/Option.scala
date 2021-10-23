object Option extends App {

  val employees = Set("John", "Sam", "Mary", "Stacie")

  println(employees.find(_ == "John"))        // Return type is an Option
  println(employees.find(_ == "John").get)    // Return type is a String

  println(employees.find(_ == "Miel"))
//  println(employees.find(_ == "Miel").get)  // java.util.NoSuchElementException


  println(employees.find(_ == "Miel").getOrElse("Employee with name Miel is not found."))  // getOrElse can be seen as a default value

}
