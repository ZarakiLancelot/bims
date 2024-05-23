package com.edwineinsen;

import java.util.*;
public class BookInventory {
    private Map<String, Book> inventory;
    private EnumSet<Genre> genres;

    public BookInventory() {
        inventory = new HashMap<>();
        genres = EnumSet.noneOf(Genre.class);
    }

    public void addBook(Book book) {
        if (inventory.containsKey(book.getISBN())) {
            System.out.println("A book with this ISBN: " + book.getISBN() + " already exists.");
            return;
        }
        inventory.put(book.getISBN(), book);
        genres.add(book.getGenre());
        // pricing.put(book.getISBN(), book.getPrice());
        System.out.println("Book added: " + book);
    }

    public void removeBook(String ISBN) {
        Book removedBook = inventory.remove(ISBN);
        if (removedBook != null) {
            // pricing.remove(ISBN);
            System.out.println("Book removed: " + removedBook);
        } else {
            System.out.println("No book found with ISBN: " + ISBN);
        }
    }

    public void updateBook(String ISBN, Book updatedBook) {
        if (!inventory.containsKey(ISBN)) {
            System.out.println("No book found with ISBN: " + ISBN);
            return;
        }
        inventory.put(ISBN, updatedBook);
        // pricing.put(ISBN, updatedBook.getPrice());
        System.out.println("Book updated: " + updatedBook);
    }

    public Book getBook(String ISBN) {
        return inventory.get(ISBN);
    }

    public List<Book> searchByTitle(String title) {
        List<Book> results = new ArrayList<>();
        for (Book book : inventory.values()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                results.add(book);
            }
        }
        return results;
    }

    public List<Book> searchByAuthor(String author) {
        List<Book> results = new ArrayList<>();
        for (Book book : inventory.values()) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                results.add(book);
            }
        }
        return results;
    }

    public List<Book> searchByGenre(Genre genre) {
        List<Book> results = new ArrayList<>();
        for (Book book : inventory.values()) {
            if (book.getGenre() == genre) {
                results.add(book);
            }
        }
        return results;
    }

    public Book searchByISBN(String ISBN) {
        return inventory.get(ISBN);
    }

    public void sellBook(String ISBN, int quantity) {
        Book book = inventory.get(ISBN);
        if (book != null) {
            if (book.getQuantity() >= quantity) {
                book.setQuantity(book.getQuantity() - quantity);
                System.out.println(quantity + " copies of " + book.getTitle() + " sold.");
            } else {
                System.out.println("Not enough stock to sell. Available quantity: " + book.getQuantity());
            }
        } else {
            System.out.println("No book found with ISBN: " + ISBN);
        }
    }

    public void restockBook(String ISBN, int quantity) {
        Book book = inventory.get(ISBN);
        if (book != null) {
            book.setQuantity(book.getQuantity() + quantity);
            System.out.println(quantity + " copies of " + book.getTitle() + " restocked.");
        } else {
            System.out.println("No book found with ISBN: " + ISBN);
        }
    }

    public void displayInventory() {
        for (Book book : inventory.values()) {
            System.out.println(book);
        }
    }
}
