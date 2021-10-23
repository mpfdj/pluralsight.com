package classes

object Main2 extends App {
  // When instantiating a class class no need to specify new (when apply method is provided)
  val course1 = Course("Hello world", "Miel de Jaeger")
  val course2 = Course("Hello world", "Miel de Jaeger")
  val course3 = Course("Hello world", "Kim de Jaeger")
  println(course1 == course2)
  println(course1 == course3)
  println(course1.author)

  // course1.author = "Bella" can't access private variable
}
