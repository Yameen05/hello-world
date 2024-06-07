import java.util.Scanner;

public class LibraryDemo {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      Library library = new Library();
      
      //while statament
      while (true) {
         System.out.println("Enter the title of the book (or type 'done' to finish adding books):");
         String title = scanner.nextLine();
            if (title.equalsIgnoreCase("done")) {
               
               break;
            
            }

         System.out.println("Enter the author of the book:");
         String author = scanner.nextLine();

         String ISBN;
         while (true) {
            System.out.println("Enter the ISBN of the book (numeric only):");
            ISBN = scanner.nextLine();
            if (isNumeric(ISBN)) {
            
               break;
            
            } else 
            
               {
            
            System.out.println("Invalid ISBN. Please enter a numeric ISBN.");
            
               }
            
            }

            Book book = new Book(title, author, ISBN);
               library.addBook(book);
            System.out.println("Book added successfully.");
        }

         System.out.println("\nLibrary Report:\n");
            library.generateReport();

        scanner.close();
    }

    // Helper method to check if a string is numeric or not
   private static boolean isNumeric(String str) {
      return str != null && str.matches("[0-9]+");
    }
}
