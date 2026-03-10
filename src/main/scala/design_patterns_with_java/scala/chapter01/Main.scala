package design_patterns_with_java.scala.chapter01

case class Book(name: String)

class Bookshelf(books: Book*) extends Iterable[Book]:
  def iterator: Iterator[Book] = books.iterator

@main
def main() =
  val bookshelf = new Bookshelf(
    Book("Around the World in 80 Days"),
    Book("Bible"),
    Book("Cinderella"),
    Book("Daddy-Long-Legs"),
  )
  for book <- bookshelf do println(book.name)
