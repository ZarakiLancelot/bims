import com.edwineinsen.Book;
import com.edwineinsen.BookInventory;
import com.edwineinsen.Genre;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static BookInventory inventory = new BookInventory();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("====================================");
            System.out.println("\nBook Inventory Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Update Book");
            System.out.println("4. Search Book");
            System.out.println("5. Display Inventory");
            System.out.println("6. Sell Book");
            System.out.println("7. Restock Book");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        addBook();
                        break;
                    case 2:
                        removeBook();
                        break;
                    case 3:
                        updateBook();
                        break;
                    case 4:
                        searchBook();
                        break;
                    case 5:
                        inventory.displayInventory();
                        break;
                    case 6:
                        sellBook();
                        break;
                    case 7:
                        restockBook();
                        break;
                    case 8:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.err.println("An error occurred: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private static void addBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String ISBN = scanner.nextLine();
        System.out.print("Enter genre: ");
        String genreInput = scanner.nextLine();
        Genre genre;
        try {
            genre = Genre.valueOf(genreInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid genre. Book not added.");
            return;
        }
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        Book book = new Book(title, author, ISBN, genre, price, quantity);
        inventory.addBook(book);
    }

    private static void removeBook() {
        System.out.print("Enter ISBN of the book to remove: ");
        String ISBN = scanner.nextLine();
        inventory.removeBook(ISBN);
    }

    private static void updateBook() {
        System.out.print("Enter ISBN of the book to update: ");
        String ISBN = scanner.nextLine();
        System.out.print("Enter new title: ");
        String title = scanner.nextLine();
        System.out.print("Enter new author: ");
        String author = scanner.nextLine();
        System.out.print("Enter new genre: ");
        String genreInput = scanner.nextLine();
        Genre genre;
        try {
            genre = Genre.valueOf(genreInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid genre. Book not updated.");
            return;
        }
        System.out.print("Enter new price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter new quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        Book updatedBook = new Book(title, author, ISBN, genre, price, quantity);
        inventory.updateBook(ISBN, updatedBook);
    }

    private static void searchBook() {
        System.out.println("Search by:");
        System.out.println("1. Title");
        System.out.println("2. Author");
        System.out.println("3. Genre");
        System.out.println("4. ISBN");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter title: ");
                String title = scanner.nextLine();
                List<Book> booksByTitle = inventory.searchByTitle(title);
                booksByTitle.forEach(System.out::println);
                break;
            case 2:
                System.out.print("Enter author: ");
                String author = scanner.nextLine();
                List<Book> booksByAuthor = inventory.searchByAuthor(author);
                booksByAuthor.forEach(System.out::println);
                break;
            case 3:
                System.out.print("Enter genre: ");
                String genreInput = scanner.nextLine();
                Genre genre;
                try {
                    genre = Genre.valueOf(genreInput.toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.err.println("Invalid genre.");
                    return;
                }
                List<Book> booksByGenre = inventory.searchByGenre(genre);
                booksByGenre.forEach(System.out::println);
                break;
            case 4:
                System.out.print("Enter ISBN: ");
                String ISBN = scanner.nextLine();
                Book book = inventory.searchByISBN(ISBN);
                if (book != null) {
                    System.out.println(book);
                } else {
                    System.out.println("No book found with ISBN: " + ISBN);
                }
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void sellBook() {
        System.out.print("Enter ISBN of the book to sell: ");
        String ISBN = scanner.nextLine();
        System.out.print("Enter quantity to sell: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        inventory.sellBook(ISBN, quantity);
    }

    private static void restockBook() {
        System.out.print("Enter ISBN of the book to restock: ");
        String ISBN = scanner.nextLine();
        System.out.print("Enter quantity to restock: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        inventory.restockBook(ISBN, quantity);
    }
}