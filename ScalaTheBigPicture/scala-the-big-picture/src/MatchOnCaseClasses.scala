object MatchOnCaseClasses extends App {

  val progInScala = Book("Programming in Scala 3rd Edition", 2016, "Martin Odersky", "9872345789435")
  val funcProgInScala = Book("Functional programming in Scala", 2014, "Paul Chiusano", "452347646")
  val scalaCookBook = Book("Scala Cookbook", 2013, "Alvin Alexander", "098890089")



  val author = progInScala match {
    case Book(_,_,author,_) => author
    case _ => "No Author"
  }

  println(author)
  println(progInScala.author)

}


case class Book(title: String, yearPublished: Integer, author: String, isbn: String)