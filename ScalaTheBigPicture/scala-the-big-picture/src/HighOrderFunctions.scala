object HighOrderFunctions extends App {
  val apple = Fruit("apple")
  val orange = Fruit("orange")
  val kiwi = Fruit("kiwi")

  val FruitBasket = List(apple, apple, orange, apple, kiwi, kiwi)

  println(FruitBasket.filter((fruit: Fruit) => fruit.name == "apple"))
  println(FruitBasket.filter((fruit) => fruit.name == "apple"))   // Fruit can be inferred by the compiler
  println(FruitBasket.filter(fruit => fruit.name == "apple"))     // Parenthesis can also be removed since there's only 1 parameter
  println(FruitBasket.filter(_.name == "apple"))                  // Even more compact when fruit is only used once on the right side of the statement
}

case class Fruit(name: String)