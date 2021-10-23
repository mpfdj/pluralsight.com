object Functions extends App {

  // Implicit return statements are used


  def plusOneOrZero(number: Int): Int = {
    if (number < 0) 0
    else number + 1
  }

  println(plusOneOrZero(-99))
  println(plusOneOrZero(99))
  // println(plusOneOrZero("hello"))  // Type mismatch


  def product(a: Int, b: Int): Int = {
    if (a == 0 || b == 0) 0
    else a * b
  }

  println(product(10, 0))
  println(product(10, 10))

  // One-liner
  // Return type is inferred
  def product2(a: Int, b: Int) = a * b

  println(product2(100, 0))


  // Anonymous function, only used once (use => operator)
  // --------------------------------------------

  val plusOne = (x: Int) => x + 1
  println(plusOne(1))
  println(plusOne(2))

  val product3 = (a: Int, b: Int) => a * b
  println(product3(1,1))

}
