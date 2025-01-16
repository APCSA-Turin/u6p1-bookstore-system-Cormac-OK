package com.example.project;

public class Book{
    //requires 5 attributes String title, String author, int yearPublished, String isbn, int quantity
    /**
     * The book's title
     */
    private String title;
    /**
     * The book's author
     */
    private String author;
    /**
     * The book's year of publication
     */
    private int yearPublished;
    /**
     * The book's international standard book number
     */
    private String isbn;
    /**
     * The amount of the book in stock
     */
    private int quantity;


    //requires 1 constructor with 5 arguments that intitialize the attribtues of the class.
    /**
     * 
     * @param title The title of the book
     * @param author The author of the book
     * @param yearPublished The year the book was published
     * @param isbn The book's international standard book number
     * @param quantity The amount of the book in stock
     */
    Book(String title, String author, int yearPublished, String isbn, int quantity){
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.isbn = isbn;
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Generates a String summarizing all of the book's attributes
     * @return A String summarizing the book's title, author, year of publication, ISBN, and quantity
     */
    public String bookInfo(){ //returns "Title: [], Author: [], Year: [], ISBN: [], Quantity: []"
        return "Title: " + title + ", Author: " + author + ", Year: " + yearPublished + ", ISBN: " + isbn + ", Quantity: " + quantity;
    }
}