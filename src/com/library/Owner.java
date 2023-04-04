package com.library;

import java.util.HashSet;
import java.util.Scanner;

public class Owner {
    private Scanner scanner;
    private String name;
    private Library library;

    public Owner (String name, Library library) {
        this.library = library;
        this.scanner = new Scanner(System.in);
        this.setName(name);
    }

    protected void getBooks() {
        System.out.println("***** *****");
        System.out.println("AVAILABLE BOOKS: ");
        HashSet<Book> books = this.library.getBooks();
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book.getName());
            }
        }
        System.out.println("***** *****");
        this.helloWorld();
    }

    protected void getUnavailableBooks() {
        System.out.println("***** *****");
        System.out.println("UNAVAILABLE BOOKS: ");
        HashSet<Book> books = this.library.getBooks();
        for (Book book : books) {
            if (!book.isAvailable()) {
                System.out.println(book.getName());
            }
        }
        System.out.println("***** *****");
        this.helloWorld();
    }

    protected void newBook() {
        System.out.println("***** *****");
        System.out.println("INSERT BOOK NAME: ");
        System.out.println("***** *****");
        String newBook = this.scanner.nextLine();
        Book book = new Book(newBook);
        boolean result = this.library.addBook(book);

        System.out.println("***** *****");
        if (result) {
            System.out.println("BOOK ADDED TO BOOKSTORE");
        } else {
            System.out.println("BOOK ALREADY REGISTERED");
        }
        System.out.println("***** *****");
        this.helloWorld();
    }

    protected void getBook() {
        System.out.println("***** *****");
        System.out.println("INSERT BOOK NAME: ");
        System.out.println("***** *****");
        String book = this.scanner.nextLine();
        Book isBook = this.library.getBook(book);
        System.out.println("***** *****");

        if (isBook == null) {
            System.out.println("");
        } else {
            System.out.println("BOOK NOT FOUND: ");
            System.out.println(isBook.getName());
            System.out.println("AVAILABLE ?: ");
            System.out.println(isBook.isAvailable());
        }
        System.out.println("***** *****");
        this.helloWorld();
    }

    protected void rentBook() {
        System.out.println("***** *****");
        System.out.println("INSERT BOOK NAME: ");
        System.out.println("***** *****");
        String book = this.scanner.nextLine();
        Book isBook = this.library.getBook(book);
        System.out.println("***** *****");
        if (isBook == null) {
            System.out.println("BOOK NOT FOUND");
        } else if (!isBook.isAvailable()) {
            System.out.println("UNAVAILABLE BOOK");
        } else {
            isBook.setAvailable();
            System.out.println("SUCCESSFULLY RENTED BOOK");
        }
        System.out.println("***** *****");
        this.helloWorld();
    }

    protected void returnBook() {
        System.out.println("***** *****");
        System.out.println("INSERT BOOK NAME: ");
        System.out.println("***** *****");
        String book = this.scanner.nextLine();
        Book isBook = this.library.getBook(book);
        System.out.println("***** *****");
        if (isBook == null) {
            System.out.println("BOOK NOT FOUND");
        } else if (isBook.isAvailable()) {
            System.out.println("NON RENTED BOOK");
        } else {
            isBook.setAvailable();
            System.out.println("SUCCESSFULLY RETURNED BOOK");
        }
        System.out.println("***** *****");
        this.helloWorld();
    }

    protected void helloWorld() {
        System.out.println("***** *****");
        System.out.println("SELECT THE OPTION YOU WANT: ");
        System.out.println("1: CONSULT AVAILABLE BOOKS");
        System.out.println("2: CONSULT UNAVAILABLE BOOKS");
        System.out.println("3: CONSULT SPECIFIC BOOK");
        System.out.println("4: REGISTER NEW BOOK");
        System.out.println("5: RENT BOOK");
        System.out.println("6: RETURN BOOK");
        System.out.println("7: EXIT");
        System.out.println("***** *****");

        int option = this.scanner.nextInt();
        this.scanner.nextLine();

        switch(option) {
            case 1 -> {
                this.getBooks();
            } case 2 -> {
                this.getUnavailableBooks();
            } case 3 ->{
                this.getBook();
            } case 4 -> {
                this.newBook();
            } case 5 -> {
                this.rentBook();
            } case 6 -> {
                this.returnBook();
            } case 7 -> {
                System.exit(1);
            }
        }
    }

    protected String getName() {
        return this.name;
    }

    protected void setName(String name) {
        this.name = name;
    }
}
