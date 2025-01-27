package com.example.project;

import java.util.Scanner;

public class Interface{

    static BookStore bookStore = new BookStore();
    static Scanner scanner = new Scanner(System.in);
    static int selection = 0;

    public static void start(){
        boolean isRunning = true;

        while (isRunning) { // Main loop
            System.out.println("-------------------------");
            System.out.println("Select an option:\n1: Open a user's account\n2: Add a new user\n3: View bookstore catalogue\n4: Add a book to inventory\n5: Exit");
            selection = scanner.nextInt();
            scanner.nextLine();
            if (selection == 1){ // Viewing a user's account
                System.out.println("Select a user:");
                System.out.print(bookStore.userList());

                selection = scanner.nextInt();
                scanner.nextLine();

                if (bookStore.getUsers()[selection] != null && selection >= 0 && selection < bookStore.getUsers().length){
                    openUserAccount(bookStore.getUsers()[selection]);
                }
                else{
                    System.out.println("Invalid selection.");
                }
            }
            else if (selection == 2){ // Adding a new user
                addUser();
            }
            else if (selection == 3){ // Viewing a list of books
                viewBooks();
            }
            else if (selection == 4){ // Adding a new book to the bookstore's catalogue
                addBook();
            }
            else if (selection == 5){ // Exiting the program
                System.out.println("Exiting");
                isRunning = false;
            }
            else{
                System.out.println("Invalid selection");
            }
        }

        scanner.close();
    }

    /**
     * Views and modifies a user's account
     * @param user The User to open
     */
    private static void openUserAccount(User user){
        boolean isInAccount = true;

        System.out.println("Opened user: " + user.getName());
        while(isInAccount){
            System.out.println("Select an option:\n1: View user info\n2: Make a purchase\n3: Exit account\n4: Delete account");
            selection = scanner.nextInt();
            scanner.nextLine();
            if (selection == 1){ // prints user info
                System.out.println(user.userInfo());
            }
            else if (selection == 2){ // purchases book
                System.out.println("Select a book to purchase:");
                System.out.print(bookStore.bookList());
                selection = scanner.nextInt();
                scanner.nextLine();
                if (selection >= 0 && selection < bookStore.getBooks().length && user.addBook(bookStore.getBooks()[selection])){ // makes sure the user is able to buy the selected book
                    System.out.println("Purchase successful.");
                    bookStore.removeBook(bookStore.getBooks()[selection]);
                }
                else if (selection < 0 || selection >= bookStore.getBooks().length){
                    System.out.println("Purchase failed. Invalid index");
                }
                else{
                    System.out.println("Purchase failed. This user has no more room in their catalogue.");
                }
            }
            else if (selection == 3){ // exits account
                isInAccount = false;
            }
            else if (selection == 4){ // deletes account
                bookStore.removeUser(user);
                isInAccount = false;
                System.out.println("Account deleted.");
            }
            else{
                System.out.println("Invalid selection.");
            }
        }
    }

    /**
     * Adds a new book to the bookstore's catalogue.
     */
    private static void addBook(){

        int index = 0;

        System.out.println("Select a mode:\n1: Append book\n2: Insert book");
        int addingMode = scanner.nextInt();
        scanner.nextLine();

        if(addingMode == 2){
            System.out.println("Select an index at which to insert the book.");
            index = scanner.nextInt();
            scanner.nextLine();
        }

        System.out.println("Book title:");
        String title = scanner.nextLine();
        System.out.println("Book author:");
        String author = scanner.nextLine();
        System.out.println("Year published:");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("ISBN:");
        String isbn = scanner.nextLine();
        System.out.println("Quantity in stock:");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        Book newBook = new Book(title, author, year, isbn, quantity);
        
        if(addingMode == 1){
            bookStore.addBook(newBook);
        }
        else if (addingMode == 2){
            bookStore.insertBook(newBook, index);
        }
    }

    /**
     * Adds a new user to the bookstore's database.
     */
    private static void addUser(){
        System.out.println("Enter the user's name:");
        String name = scanner.nextLine();
        User newUser = new User(name, IdGenerate.generateID());
        bookStore.addUser(newUser);
    }

    /**
     * Prints a list of the books in the bookstore's catalogue.
     */
    private static void viewBooks(){
        for(Book book: bookStore.getBooks()){
            System.out.println(book.bookInfo());
        }
    }
}