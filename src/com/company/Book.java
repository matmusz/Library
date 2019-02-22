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
        id = counter++;
    }

    public void ifAvailable(){
        if(ifAvailable==true)
            System.out.println("Yes");
        else System.out.println("No");

    }
    public String initialNames() {
        String temp = this.writerNames;
        String[]tm = temp.split(" ");
        String tur = (String) tm[0].charAt(0);
        char tur1 = tm[1].charAt(0);
          temp = tur+tur1;
          return ;

        }








    @Override
    public String toString() {
        String s;
        if (ifAvailable == true)
            s = "Yes";
        else
            s = "No";

        return "Book{" +
                "id=" + id +
                ", numberOfLending=" + numberOfLending +
                ", yearOfPublication=" + yearOfPublication +
                ", title='" + title + '\'' +
                ", writerSurname='" + writerSurname + '\'' +
                ", writerNames='" + writerNames + '\'' +
                ", typeOfBook='" + typeOfBook + '\'' +
                ", available='" + s + '\'' +
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

    public String getWriterSurname() {
        return writerSurname;
    }
}
