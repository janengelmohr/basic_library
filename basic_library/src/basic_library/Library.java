/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package basic_library;

/**
 *
 * @author jan
 */
public class Library {

    private String[] inventory = null;
    private String[][] userAccounts = new String[20][6];
    private static Library instance = null;
    
    
    private Library() {
    }
    
    public static Library getTheLibrary() {
        if(instance==null) { instance = new Library(); 
        }
            return instance;
        }
    
    public boolean addBook(String newBook) {
    int counter = 0;
    for(String s : inventory) {
    if(s.equals(newBook)) {
        return false; }
    counter++;
    }
    if(counter<20) {
    inventory[counter] = newBook;
    return true;
    }
    return false;
    }
    
    public boolean removeBook(String remove) {
        int counter = 0;
        for(String s : inventory) {
            if(s.equals(remove)) {
                inventory[counter] = null;
                return true;
            }
            counter++;
        }
        return false;
    }
    
    public String getBook(String book) {
        for(String s : inventory) {
            if(s.equals(book)) {
                return s;
            }
        }
        return null;
    }
    
    public boolean borrowBook(String book, String user) {
        if(!hasUserAccount(user)) {
            return false;
        }
        for(String[] s : userAccounts) {
        int bookCounter = 0;
            if(s[0].equals(user)) {
                for(String b : s) {
                    if (b.equals(book)) {
                        /*user has already borrowed this book*/
                        return false;
                    }
                    bookCounter++;
                    if(bookCounter>5) {
                        /*user borrowed 5 books*/
                        return false;
                    }
                    /*add the book*/
                    s[bookCounter] = book;
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean returnBook(String book, String user) {
        if(!hasUserAccount(user)) {
            return false;
        }
        for(String[] s : userAccounts) {
        int bookCounter = 0;
            if(s[0].equals(user)) {
                for(String b : s) {
                    if (b.equals(book)) {
                        /*user has already borrowed this book*/
                        s[bookCounter] = null;
                        return true;
                    }
                    bookCounter++;
                }
            }
        }
        return false;
    }
    
    
    public boolean hasUserAccount(String pi) {
        for(String[] s : userAccounts) {
            if(s[0].equals(pi)) {
                return true;
            }
        }
        return false;
    }
    
}

    
    


    

