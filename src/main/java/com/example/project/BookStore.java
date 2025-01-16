package com.example.project;

public class BookStore{

    //requires at least 2 attributes Book[] books, User[] users (initialized to an empty array of 10 max users) 
    /**
     * The books that this store possesses. A dynamic array.
     */
    Book[] books = new Book[0];

    /**
     * The users of this bookstore. A static array.
     */
    User[] users = new User[10];
    //requires 1 empty constructor

    public BookStore(){}

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
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
        for(int i = 0; i < users.length; i ++){
            if (users[i] == user){
                users[i] = null;
            }
        }

        consolidateUsers();
    }
    /**
     * Moves all non-null users toward the start of users, and moves all nulls toward the end of users
     */
    public void consolidateUsers(){
        User[] newArray = new User[users.length];
        int i = 0;

        for (User user: users){
            if (user != null){
                newArray[i] = user;
                i++;
            }
        }

        users = newArray;
    }
    /**
     * Adds a book object to the end of books.
     * @param book The book object to add.
     */
    public void addBook(Book book){
        Book[] newArray = new Book[books.length + 1];
        for (int i = 0; i < books.length; i ++){
            newArray[i] = books[i];
        }
        newArray[books.length] = book;
        
        books = newArray;

    }

    /**
     * Inserts Book book at index index in books. Extends books array by 1 in order to accommodate the inserted book. All books after index are moved down by 1 index.
     * @param book The book to insert.
     * @param index The index at which to insert book.
     */
    public void insertBook(Book book, int index){
        Book[] newArray = new Book[books.length + 1];
        for (int i = 0; i < index; i ++){
            newArray[i] = books[i];
        }
        newArray[index] = book;
        for (int i = index + 1; i < newArray.length; i++){
            newArray[i] = books[i-1];
        }
        
        books = newArray;
    }


    public void removeBook(Book book){
        int indexToRemove = -1;
        for (int i = 0; i < books.length; i ++){
            if(books[i] == book){
                indexToRemove = i;
            }
        }

        books[indexToRemove].setQuantity(books[indexToRemove].getQuantity()-1);

        if (books[indexToRemove].getQuantity() == 0){
            Book[] newArray = new Book[books.length -1];

            int placementIndex = 0;
            for (int i = 0; i < books.length; i++){
                if (i != indexToRemove){
                    newArray[placementIndex] = books[i];
                    placementIndex ++;
                }
            }
            books = newArray;
        }

    }
       
    public String bookStoreBookInfo(){
        String str = "";
        for(Book book: books){
            str += book.bookInfo() + "\n";
        }
        return str;
    } //you are not tested on this method but use it for debugging purposes

    public String bookStoreUserInfo(){
        String str = "";
        for(User user: users){
            if(user != null){
                str += user.userInfo() + "\n";
            }
            else{
                str += "null\n";
            }
        }
        return str;
    } //you are not tested on this method but use it for debugging purposes

}