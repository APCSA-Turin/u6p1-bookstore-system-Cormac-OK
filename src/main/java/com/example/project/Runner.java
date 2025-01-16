package com.example.project;

public class Runner{
    public static void main(String[] args) {
        BookStore store = new BookStore(); //create a new bookstore with 6 empty books
        User x = new User("x","100");
        User y = new User("y","101");
        User[] users = {x,null,null,y};
        store.setUsers(users);

        System.out.println(store.bookStoreUserInfo());
        System.out.println("\n\n");

        store.consolidateUsers();
        User[] expected = {x,y,null,null};

        System.out.println(store.bookStoreUserInfo());


    }
}