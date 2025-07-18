//Implemented the project using switch case

import java.util.*;
class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title.toLowerCase();
        this.author = author.toLowerCase();
    }

    public void display() {
        System.out.println("Book ID: " + bookId + ", Title: " + title + ", Author: " + author);
    }
}

// Main class
public class Library {
    private List<Book> books = new ArrayList<>();

    // Add a new book
    public void addBook(int id, String title, String author) {
        books.add(new Book(id, title, author));
        System.out.println("Book added.");
    }

    // Linear Search by title
    public void linearSearchByTitle(String title) {
        boolean found = false;
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                b.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book not found (linear search).");
        }
    }

    // Binary Search by title (works when list is sorted)
    public void binarySearchByTitle(String title) {
        // Sorting by title
        books.sort(Comparator.comparing(b -> b.title));

        int left = 0, right = books.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            Book midBook = books.get(mid);
            int cmp = midBook.title.compareToIgnoreCase(title);

            if (cmp == 0) {
                midBook.display();
                return;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("Book not found (binary search).");
    }

    // Display all books
    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }

        for (Book b : books) {
            b.display();
        }
    }

    // Main menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        while (true) {
            System.out.println("1. Add Book");
            System.out.println("2. Search Book by Title (Linear Search)");
            System.out.println("3. Search Book by Title (Binary Search)");
            System.out.println("4. Display All Books");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {

                //Add  a new book
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    lib.addBook(id, title, author);
                    break;

                    //search book by linear search

                case 2:
                    System.out.print("Enter title to search (linear_search): ");
                    String linearTitle = sc.nextLine();
                    lib.linearSearchByTitle(linearTitle);
                    break;

                    //search book by binary search

                case 3:
                    System.out.print("Enter title to search (binary_search): ");
                    String binaryTitle = sc.nextLine();
                    lib.binarySearchByTitle(binaryTitle);
                    break;

                case 4:
                    lib.displayAllBooks();
                    break;

                case 5:
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
