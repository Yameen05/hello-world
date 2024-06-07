import java.util.ArrayList;

public class Library {
   private ArrayList books;

   // create an array
   public Library() {
      books = new ArrayList();
      }

   // here is a method to add a book
   public void addBook(Book book) {
      books.add(book);
      }

   // Method to generate a report
   public void generateReport() {
      for (Object obj : books) {
         Book book = (Book) obj;
         System.out.println("Title: " + book.getTitle());
         System.out.println("Author: " + book.getAuthor());
         System.out.println("ISBN: " + book.getISBN());
         System.out.println("Valid ISBN: " + book.validateISBN());           
         // create a line between each report like shown in sample video
         System.out.println("----------------------");
        }
    }
}
