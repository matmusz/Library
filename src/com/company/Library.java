package com.company;

import java.io.*;
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

    public String shortVersion() {

        String total = "\n";
        for (int i = 0; i < howManyBooks; i++) {
            Book b = books[i];
            total = total + b.getId() + " " + b.initialNames() + " " + b.getWriterSurname() + " " + ",,"
                    + b.getTitle() + "''" + " " + b.returnYesorNo();
        }
        return total + "\n";

    }

     /*   public void saveToFile()throws IOException{
        FileWriter file = null;
        try {
            file = new FileWriter("baza.txt");
        }catch (IOException e){
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(file);
        try{
            bw.
        }

    }*/

    @Override
    public String toString() {
        String total = "\n";
        for (int i = 0; i < howManyBooks; i++) {
            Book b = books[i];
            total = total + b.toString();
        }

        return total + "\n" + "Books in library " + howManyBooks;
    }


}


