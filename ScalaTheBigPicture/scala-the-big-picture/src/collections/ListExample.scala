package collections

object ListExample extends App {

  // A list in scala is immutable same goes for Map and Set
  val numbers = List(1, 2, 3, 4)

  println(numbers.head)
  println(numbers.tail)
  println(numbers.init) // The init() method is utilized to find all the elements of the list except the last one.
  println(numbers.last)
  println(numbers(0))

  println(numbers :+ 5) // append
  println(0 +: numbers) // prepend
  println(numbers ++ List(5, 6, 7)) // append list
  println(List(-1, 0) ++ numbers) // prepend list

  println(numbers.drop(1))
  println(numbers.dropRight(1))
  println(numbers.dropWhile(_ < 3)) // High order function which takes a Predicate

  println(numbers) // prints the original List(1,2,3,4)
}
