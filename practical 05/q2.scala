import scala.io.StdIn.readLine;
object Library{
    case class Book(title:String, author:String, isbn:String);

    var library:Set[Book] = Set(
        Book("Lord of the Rings", "JRR Tolkien", "6582897532"),
        Book("My Brilliant Friend", "Elena Ferrante", "1324937221"),
        Book("Jurassic Park", "Michael Crichton", "8362729946")
    )

    def addBook(newBook:Book):Unit={
        library = library + newBook;
        println(newBook.title + " has been added to library!");
    }

    def removeBook(isbn:String):Unit={
        val bookToRemove = library.find(_.isbn == isbn)
        bookToRemove match{
            case Some(book) =>
                library = library -book
                println(book.title+" has been removed from library.")
            case None => 
                println("Book not found.");
        }
    }

    def checkBook(isbn:String):Unit={
        if(library.exists(_.isbn == isbn)){
            println("Book is available!")
        }else{
            println("Book is unavailable!");
        }
    }

    def displayLibrary():Unit ={
        println("---Current library---")
        library.foreach(book => println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}"))
    }

    def searchBooksByTitle(title:String):Unit={
        val foundBooks = library.filter(_.title.equalsIgnoreCase(title))
        if(foundBooks.nonEmpty){
            println("Books found with title " + title)
            foundBooks.foreach(book => println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}"))
        }else{
            println("No books found with this title.")
        }
    }

    def displayBooksByAuthor(author:String):Unit={
        val booksByAuthor = library.filter(_.author.equalsIgnoreCase(author))
        if(booksByAuthor.nonEmpty){
            println("Books by author "+author)
            booksByAuthor.foreach(book => println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}"))
        }else{
            println("Sorry, No books written by this author were found.")
        }
    }

    def main(args:Array[String]):Unit={
        displayLibrary();

        val newBook = Book("Oliver Twist", "Charles Dickens", "7362914783");
        addBook(newBook);

        displayLibrary();

        removeBook("8362729946");

        displayLibrary();

        //checking if book with isbn 6582897532 is in the library
        checkBook("6582897532");

        searchBooksByTitle("Lord of the Rings");

        displayBooksByAuthor("Charles Dickens")
    }


}
