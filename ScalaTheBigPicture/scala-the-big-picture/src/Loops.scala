object Loops extends App {

  val numbers = List(1,2,3,4,5,6,7,8,9,10)
  val letters = List("a","b", "c")

// Imperative for loops
// ------------------------------------------------

  // Multiple conditions
  for(
    number <- numbers
    if (number % 2 == 0)
    if (number > 5)
  ) print(number)

  println()

  // Nested loop (using curly braces)
  for {
    number <- numbers
    letter <- letters
  } println(number + letter)


// Functional for loop
// ------------------------------------------------

  val even_numbers_multiplied_by_2 = for(number <- numbers if (number % 2 == 0)) yield { number * 2}
  println(even_numbers_multiplied_by_2)

  val numbers_and_letters = for {
    number <- numbers
    letter <- letters
  } yield number + letter
  println(numbers_and_letters)

}
