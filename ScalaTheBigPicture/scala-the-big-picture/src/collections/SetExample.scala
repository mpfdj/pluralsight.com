package collections

object SetExample extends App {

  val numbers = Set(1, 1, 2, 2, 3, 3, 4, 4)

  println(numbers)
  println(numbers + 6)
  println(numbers - 2)
  println(numbers ++ Set(0, 10))
  println(numbers.min)
  println(numbers.max)
  println(numbers)


}
