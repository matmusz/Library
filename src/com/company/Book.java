package com.company;

import java.io.Serializable;

public class Book implements Serializable {

    private final int id;
    private static int counter = 1;
    private int numberOfLending = 0;

    private int yearOfPublication;

    private String title;
    private String writerSurname;
    private String writerNames;
    private String typeOfBook;

    private boolean ifAvailable = true;


    public Book(String writerNames, String writerSurname, String title, int yearOfPublication, String typeOfBook) {
        this.yearOfPublication = yearOfPublication;
        this.title = title;
        this.writerSurname = writerSurname;
        this.writerNames = writerNames;
        this.typeOfBook = typeOfBook;
        this.id = counter++;

    }

    public Book() {
        yearOfPublication = 0;
        title = null;
        writerSurname = null;
        writerNames = null;
        typeOfBook = null;
        id = counter;
        counter++;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", counter=" + counter +
                ", numberOfLending=" + numberOfLending +
                ", yearOfPublication=" + yearOfPublication +
                ", title='" + title + '\'' +
                ", writerSurname='" + writerSurname + '\'' +
                ", writerNames='" + writerNames + '\'' +
                ", typeOfBook='" + typeOfBook + '\'' +
                ", ifAvailable=" + ifAvailable +
                '}' +
                "\n";
    }


    public int getId() {
        return id;
    }

    public void setIfAvailable(boolean ifAvailable) {
        this.ifAvailable = ifAvailable;
    }
}