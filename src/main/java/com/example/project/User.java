package com.example.project;

public class User{
    //requires 3 private attributes String name, String id, Book[] books that is initialized to empty
    /**
     * The user's name
     */
    private String name;
    /**
     * The user's unique id number
     */
    private String id;
    /**
     * The books the user has
     */
    private Book[] books = new Book[5];

    /**
     * Initializes a user with name name and id id
     */
    User(String name, String id){
        this.name = name;
        this.id = id;
    }
 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getid() {
        return id;
    }

    public void setid(String id) {
        id = id;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    /**
     * Generates a string with the title of each of the user's books on a separate line.
     * @return A list of the user's books. If a slot is null, it will be filled with "empty"
     */
    public String bookListInfo(){
        String str = "";
        for (Book book: books){
            if(book != null){
                str += book.bookInfo() + "\n";
            }
            else{
                str += "empty\n";
            }
        }
        return str;

    }

    /**
     * Generates a string summarizing the user's attributes
     * @return A string summarizing the user's name and id, and listing their books
     */
    public String userInfo(){
        return "Name: " + name + "\nId: " + id + "\nBooks: \n" + bookListInfo();
    }

    /**
     * Attempts to add Book book to the first empty index in books. Fails if books does not have an empty index.
     * @param book The book to add
     * @return Whether the book was successfully added
     */
    public boolean addBook(Book book){
        boolean hasPlaced = false;
        for(int i = 0; i < books.length; i ++){
            if ((!hasPlaced) && books[i] == null){
                books[i] = book;
                hasPlaced = true;
                return true;
            }
        }
        return false;
    }
       
}