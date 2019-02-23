package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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

    public String initialNames() {     //takes initials from names

        String temp = this.writerNames;
        String t = "";
        char ch;
        String[] tm = temp.split(" ");

        for (int i = 0; i < tm.length; i++) {
            ch = tm[i].charAt(0);
            t = t + ch + ".";
        }
        return t;
    }

    public String returnYesorNo(){
        String s;
        if (ifAvailable == true)
            return s = "Yes";
        else
            return s = "No";
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", numberOfLending=" + numberOfLending +
                ", yearOfPublication=" + yearOfPublication +
                ", title='" + title + '\'' +
                ", writerSurname='" + writerSurname + '\'' +
                ", writerNames='" + writerNames + '\'' +
                ", typeOfBook='" + typeOfBook + '\'' +
                ", available='" + returnYesorNo() + '\'' +
                '}' +
                "\n";
    }


    public int getId() {
        return id;
    }

    public boolean isIfAvailable() {
        return ifAvailable;
    }

    public void setIfAvailable(boolean ifAvailable) {
        this.ifAvailable = ifAvailable;
    }

    public void setNumberOfLending(int numberOfLending) {
        this.numberOfLending = numberOfLending;
    }

    public int getNumberOfLending() {
        return numberOfLending;
    }

    public void setWriterSurname(String writerSurname) {
        this.writerSurname = writerSurname;
    }

    public void saveToFile()throws IOException {
        FileWriter file = null;
        try {
            file = new FileWriter("baza.txt");
            file.write(writerNames+", "+writerSurname+"; "+title+"; "+yearOfPublication+"; "+typeOfBook);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            file.close();
        }
    }



    public String getWriterSurname() {
        return writerSurname;


    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
