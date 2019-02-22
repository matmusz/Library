package com.company;

import java.io.FileReader;
import java.io.Serializable;
import java.util.Arrays;

public class Library implements Serializable {

    Book[] books;
    int howManyBooks = 0;

    public Library() {
        books = new Book[1000];
    }

    public void addBook(Book book) {
        if (howManyBooks < 1000) {
            books[howManyBooks] = book;
            howManyBooks++;
        }
        if (howManyBooks == 1000) {
            System.out.println("To many books");
        }
    }

    public String shortVersion(){

        String total = "\n";
        for (int i = 0; i < howManyBooks; i++) {
            Book b = books[i];
            total = total + b.initialNames();
        }
        return total + "\n";

    }

    public void saveToFile(){
        FileWriter file = null

        try{
            file=new FileReader();

        }

    }

    @Override
    public String toString() {
        String total = "\n";
        for (int i = 0; i < howManyBooks; i++) {
            Book b = books[i];
            total = total + b.toString();
        }

        return total + "\n" + "Books in library "+howManyBooks;
    }


}


