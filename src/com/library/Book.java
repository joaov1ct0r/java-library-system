package com.library;

public class Book {
    private String name;
    private boolean isAvailable;

    public Book (String name) {
        this.setName(name);
        this.isAvailable = true;
    }

    protected String getName() {
        return this.name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected boolean isAvailable() {
        return this.isAvailable;
    }

    protected void setAvailable() {
        this.isAvailable = !isAvailable;
    }
}
