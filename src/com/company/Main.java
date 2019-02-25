package com.company;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

        static String fileName = null;
        static Library lib = new Library();
        static Scanner scan = new Scanner(System.in);
        static Boolean running = true;

        public static void main(String[] args) throws IOException{

            while (running) {
                System.out.println("**************************************************************************");
                System.out.println("**   " + " 0. Exit                                                        " + "   **");
                System.out.println("**   " + " 1. Display the list of books(ID,Name,Surname,Title,IsAvailable)" + "   **");
                System.out.println("**   " + " 2. Display full info list                                      " + "   **");
                System.out.println("**   " + " 3. Add book to library                                         " + "   **");
                System.out.println("**   " + " 4. Edit book info                                              " + "   **");
                System.out.println("**   " + " 5. Lent the book(give ID)                                      " + "   **");
                System.out.println("**   " + " 6. Return the book(give ID)                                    " + "   **");
                System.out.println("**   " + " 7. Search for book(Surname, Title, Type of book)               " + "   **");
                System.out.println("**   " + " 8. Extra menu TOP 5                                            " + "   **");
                System.out.println("**   " + " 9. Import from .txt file                                       " + "   **");
                System.out.println("**   " + "10. Sorted list of book(Surname, Year, Number of Rentals, Title " + "   **");
                System.out.println("**************************************************************************");

                int answer = scan.nextInt();
                switch (answer) {
                    case 0:
                        running=false;
                        break;
                    case 1:
                        System.out.println(lib.shortVersion());
                        break;

                    case 2:
                        System.out.println(lib.toString());
                        break;

                    case 3:
                        addBook();
                        break;

                    case 4:
                        editBook();
                        break;

                    case 5:
                        lentBook();
                        break;

                    case 6:
                        returnBook();
                        break;
                    case 7:
                        searching();
                        break;

                    case 9:
                        lib.books[0].saveToFile();
                        break;

                }


            }System.exit(0);


        }

        private static void addBook(){
            String title;
            String writerSurname;
            String writerNames;
            String typeOfBook;
            int yearOfPublication;

            scan.nextLine();
            System.out.println("Give me a title");
            title = scan.nextLine();

            System.out.println("Give me a writer names");
            writerNames = scan.nextLine();

            System.out.println("Give me a writer surname");
            writerSurname = scan.nextLine();

            System.out.println("Give me types of book");
            typeOfBook = scan.nextLine();

            while(true){
                Scanner scan = new Scanner(System.in);
                System.out.println("Give me year of publication");
                try {
                yearOfPublication = scan.nextInt();
                scan.nextLine();
                break;}
                catch (InputMismatchException e) {
                System.out.println("Please write number");
                //scan.next();
                continue;}
            }
            Book b = new Book(writerNames, writerSurname, title, yearOfPublication, typeOfBook);
            lib.addBook(b);
        }

        private static void lentBook(){
            int id;
            System.out.println("Give an ID");
            id = scan.nextInt();
            if(lib.books[id-1].isIfAvailable()==false){
                System.out.println("Book has been loaned");
            }else
            lib.books[id-1].setIfAvailable(false);
        }

        private static void returnBook() {
            int id;
            System.out.println("Give an ID");
            id = scan.nextInt();
            if(lib.books[id-1].isIfAvailable()==true){
                System.out.println("Book has been returned or Haven't been loaned");
            }else
            {lib.books[id - 1].setIfAvailable(true);
            int temp;
            temp=lib.books[id - 1].getNumberOfLending();
            temp++;
            lib.books[id - 1].setNumberOfLending(temp);
            System.out.println("Book has been loaned " + temp);}
        }

        private static void editBook(){
            int chose;
            int id;
            boolean running1=true;
            while(running1) {
                System.out.println("1. Change surname");
                System.out.println("2. Change name");
                System.out.println("3. Change title");
                System.out.println("4. Change year of publicity");
                System.out.println("5. Change types of book");
                System.out.println("6. Return");

            chose = scan.nextInt();
                switch (chose) {
                    case 1:
                        System.out.println("Give an ID");
                        id = scan.nextInt();
                        System.out.println("Current surname " + lib.books[id-1].getWriterSurname());
                        System.out.println("Write corrected surname");
                        lib.books[id - 1].setWriterSurname(scan.next());
                        break;
                    case 2:
                        System.out.println("Give an ID");
                        id = scan.nextInt();
                        System.out.println("Current names " + lib.books[id-1].getWriterNames());
                        System.out.println("Write corrected name");
                        lib.books[id - 1].setWriterNames(scan.next());
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        running1=false;
                        break;
                }
                }
            }

        private static void searching(){

            boolean run=true;

            while(run){
                System.out.println("1. Search for author");
                System.out.println("2. Search for title");
                System.out.println("3. Search for type");
                System.out.println("4. Return");

                int number = scan.nextInt();

                switch(number){

                    case 1:
                        scan.nextLine();
                        System.out.println("Give a surname");
                        String name=scan.next();

                        for(int i=0 ; i<lib.books.length ; i++)
                        if (lib.books[i].getWriterSurname().contains(name)){
                            System.out.println(lib.books[i].toString());
                        } else System.out.println("Book don't exit");

                        break;

                    case 2:
                        System.out.println("cos");
                        break;

                    case 3:
                        scan.nextLine();
                        System.out.println("Give a title");
                        String type=scan.next();

                        for(int i=0 ; i<lib.books.length ; i++)
                            if (type.equals(lib.books[i].getWriterSurname())){
                                System.out.println(lib.books[i].toString());
                            } else System.out.println("Book don't exit");
                        break;

                    case 4:
                        run=false;
                        break;
                }


            }
        }


        }





