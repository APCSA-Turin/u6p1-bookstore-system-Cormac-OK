package com.example.project;

public class BookStore{

    //requires at least 2 attributes Book[] books, User[] users (initialized to an empty array of 10 max users) 
    /**
     * The books that this store possesses. A dynamic array.
     */
    Book[] books = new Books[0];

    /**
     * The users of this bookstore. A static array.
     */
    User[] users = new User[10];
    //requires 1 empty constructor

    public Bookstore(){}

    public User[] getUsers() {
        return users;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public Book[] getBooks() {
        return books;
    }

    /**
     * Sets the first null index of the array users to a reference to user.
     * @param user The user to be added
     */
    public void addUser(User user){
        boolean isPlaced = false;
        for (int i = 0; i < users.length; i ++){
            if((!isPlaced) && users[i] == null){
                users[i] = user;
                isPlaced = true;
            }
        }
    } 

    /**
     * Finds the reference to User user in users, and sets it to null.
     * @param user The user to remove
     */
    public void removeUser(User user){
        for(int i = 0; i<users.length; i ++){
            if (users[i] == user){
                users[i] = null;
            }
        }
    }

    public void consolidateUsers(){
        User[] newArray = new User[10];
        int i = 0;

        for (User user: users){
            if (user != null){
                newArray[i] = user;
                i++;
            }
        }

        users = newArray;
    }

    public void addBook(Book book){
        Book[] newArray = new Book[books.length + 1];
        for (int i = 0; i < books.length; i ++){
            newArray[i] = books[i];
        }

    }

    public void insertBook(Book book, int index){}

    public void removeBook(Book book){}
       
    public String bookStoreBookInfo(){} //you are not tested on this method but use it for debugging purposes

    public String bookStoreUserInfo(){} //you are not tested on this method but use it for debugging purposes

}