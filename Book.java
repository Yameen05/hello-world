public class Book {
   private String title;
   private String author;
   private String ISBN;

   // Empty constructor
   public Book() {}

   // this is where i Constructor with arguments
   public Book(String t, String a, String isbn) {
      title = t;
      author = a;
      ISBN = isbn;
    }

   // here is the Getters
   public String getTitle() {
      return title;
   }

   public String getAuthor() {
      return author;
    }

   public String getISBN() {
      return ISBN;
    }

    // here is the Setters
    public void setTitle(String t) {
      title = t;
    }

    public void setAuthor(String a) {
      author = a;
    }

    public void setISBN(String isbn) {
      ISBN = isbn;
    }

    // a method to validate the ISBN
    public boolean validateISBN() {
        if (ISBN == null) {
            return false;
        }
        if (ISBN.length() == 10) {
            return validateISBN10(ISBN);
        } else if (ISBN.length() == 13) {
            return validateISBN13(ISBN);
        } else {
            return false;
        }
     }

    // Validate ISBN-10
   private boolean validateISBN10(String isbn) {
      int sum = 0;
         for (int i = 0; i < 9; i++) {
            sum += (10 - i) * Character.getNumericValue(isbn.charAt(i));
        }
   char lastChar = isbn.charAt(9);
      int checkDigit;
         if (lastChar == 'X') {
             checkDigit = 10;
        } else {
            checkDigit = Character.getNumericValue(lastChar);
        }
        sum += checkDigit;
        return sum % 11 == 0;
    }

    // Validate ISBN-13
    private boolean validateISBN13(String isbn) {
        int sum = 0;
        for (int i = 0; i < 12; i++) {
            int digit = Character.getNumericValue(isbn.charAt(i));
            if (i % 2 == 0) {
                sum += digit;
            } else {
                sum += 3 * digit;
            }
        }
        int checkDigit = Character.getNumericValue(isbn.charAt(12));
        if (sum % 10 == 0) {
            return checkDigit == 0;
        } else {
            return checkDigit == (10 - (sum % 10));
        }
    }

    // do a toString method
    public String toString() {
        return "Title: " + title + "\nAuthor: " + author + "\nISBN: " + ISBN + "\nValid ISBN: " + validateISBN();
    }
}
