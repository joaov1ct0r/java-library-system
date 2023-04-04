package com.library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Owner owner = new Owner("Peter Parker", library);
        System.out.println("***** *****");
        System.out.println("Welcome to the library, the owner " + owner.getName() + " is ready to serve you");
        System.out.println("***** *****");
        owner.helloWorld();
    }
}
