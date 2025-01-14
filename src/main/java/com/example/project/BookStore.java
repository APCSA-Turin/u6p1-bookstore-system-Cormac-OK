package com.example.project;

public class BookStore{

    //requires at least 2 attributes Book[] books, User[] users (initialized to an empty array of 10 max users) 
    Book[] books;

    User[] users = new User[10];
    //requires 1 empty constructor

    public User[] getUsers() {
        return users;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public Book[] getBooks() {
        return books;
    }

    public void addUser(User user){} 

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

    public void addBook(Book book){}

    public void insertBook(Book book, int index){}

    public void removeBook(Book book){}
       
    public String bookStoreBookInfo(){} //you are not tested on this method but use it for debugging purposes

    public String bookStoreUserInfo(){} //you are not tested on this method but use it for debugging purposes

}