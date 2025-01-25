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
        // Iterates over users, and sets any references to user to null
        for(int i = 0; i < users.length; i ++){
            if (users[i] == user){
                users[i] = null;
            }
        }

        // Calls consolidateUsers() to shift all users after user down by one index
        consolidateUsers();
    }
    /**
     * Moves all non-null users toward the start of users, and moves all nulls toward the end of users
     */
    public void consolidateUsers(){
        User[] newArray = new User[users.length]; // A new array that users will eventually be set to

        // iterates over the original user list, adding each non null user to the first empty slot in the new array
        int placementIndex = 0;
        for (User user: users){ 
            if (user != null){
                newArray[placementIndex] = user;
                placementIndex++;
            }
        }

        users = newArray;
    }
    /**
     * Adds a book object to the end of books.
     * @param book The book object to add.
     */
    public void addBook(Book book){
        // Creates a new Book[] array that books will eventually be set to, with the correct new length
        Book[] newArray = new Book[books.length + 1];

        // Copies all of books to the new array
        for (int i = 0; i < books.length; i ++){
            newArray[i] = books[i];
        }

        // Sets the last item in the new array to
        newArray[books.length] = book;
        
        books = newArray;

    }

    /**
     * Inserts Book book at index index in books. Extends books array by 1 in order to accommodate the inserted book. All books after index are moved down by 1 index.
     * @param book The book to insert.
     * @param index The index at which to insert book.
     */
    public void insertBook(Book book, int index){
        // Creates a new Book[] array that books will eventually be set to, with the correct new length
        Book[] newArray = new Book[books.length + 1];

        // Adds all the books before index to the new array
        for (int i = 0; i < index; i ++){
            newArray[i] = books[i];
        }

        // sets the item at index index of the new array to book
        newArray[index] = book;

        // Adds all the books after index to the new array
        for (int i = index + 1; i < newArray.length; i++){
            newArray[i] = books[i-1];
        }
        
        books = newArray;
    }


    /**
     * Decreases the quantity of Book book by 1, and then if that quantity is now zero, removes book from books.
     * @param book The book to remove
     */
    public void removeBook(Book book){

        book.setQuantity(book.getQuantity()-1); // Decreases the quantity of book by one

        
        // The following section is to remove book from books if its quantity is zero.
        if (book.getQuantity() == 0){

            // Finding the index in books of book:
            int indexToRemove = -1;
            for (int i = 0; i < books.length; i ++){
                if(books[i] == book){
                    indexToRemove = i;
                }
            }

            // Creating a new array of the correct length to replace books
            Book[] newArray = new Book[books.length -1];

            // Iterating over the new book array, adding only the books that have not been modified
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
       
    /**
     * @return A list of the info of all the books in books
     */
    public String bookStoreBookInfo(){ //you are not tested on this method but use it for debugging purposes
        String str = "";
        for(Book book: books){
            str += book.bookInfo() + "\n";
        }
        return str;
    }

    /**
     * @return A list of the info of all the users in users
     */
    public String bookStoreUserInfo(){ //you are not tested on this method but use it for debugging purposes
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
    }

}