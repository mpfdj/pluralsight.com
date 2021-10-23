package collections


// https://docs.scala-lang.org/tour/tuples.html

object Tuple extends App {

  val ingredient = ("Sugar", 25) // The inferred type of ingredient is (String, Int), which is shorthand for Tuple2[String, Int].
  println(ingredient._1)
  println(ingredient._2)

}
