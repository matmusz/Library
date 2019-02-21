package com.company;

import java.util.Scanner;

public class Main {


        static String fileName = null;
        static Library lib = new Library();
        static Scanner scan = new Scanner(System.in);
        static Boolean running = true;
        Book b1 = new Book("Henryk, Adam", "Sienkiewicz", "W pustynii i puszczy", 1900, "drama;adventure;family");
        Book b2 = new Book("Adam", "Mickiewicz", "Pan Tadeusz", 1800, "drama");
        Book b3 = new Book("Wladyslaw", "Reymont", "Chlopi", 1850, "drama;family");

        public static void main(String[] args) {

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
                        System.out.println(lib.toString());
                        break;

                    case 2:
                        System.out.println(lib.books[1]);
                        break;

                    case 3:
                        addBook();
                        break;

                    case 5:
                        lentBook();
                        break;

                    case 6:
                        returnBook();
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

            System.out.println("Give me a title");
            title = scan.next();

            System.out.println("Give me a writer names");
            writerNames = scan.next();

            System.out.println("Give me a writer surname");
            writerSurname = scan.next();

            System.out.println("Give me types of book");
            typeOfBook = scan.next();

            System.out.println("Give me year of publication");
            yearOfPublication = scan.nextInt();

            Book b = new Book(writerNames, writerSurname, title, yearOfPublication, typeOfBook);
            lib.addBook(b);


        }

        private static void lentBook(){
            int id;
            System.out.println("Give an ID");
            id = scan.nextInt();

            lib.books[id-1].setIfAvailable(false);
        }

        private static void returnBook() {
            int id;
            System.out.println("Give an ID");
            id = scan.nextInt();

            lib.books[id - 1].setIfAvailable(true);
        }
    }




