package com.library;

import java.util.HashSet;
import java.util.Optional;

public class Library {
    private final HashSet<Book> books;
    public Library () {
        this.books = new HashSet<>();
    }

    protected HashSet<Book> getBooks() {
        return this.books;
    }

    protected boolean addBook(Book book) {
        boolean isBookRegistered = this.books.contains(book);

        if (isBookRegistered) {
            return false;
        } else {
            this.books.add(book);
            return true;
        }
    }

    protected Book getBook(String book) {
        Optional<Book> selectedBook = this.books.stream()
                .filter(b -> b.getName().equals(book))
                .findFirst();

        if (selectedBook.isEmpty()) {
            return null;
        } else {
            return selectedBook.get();
        }
    }
}