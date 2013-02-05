
package basic_library;

/**
 *
 * @author moarCookies
 */
public class Library {

    private String[] inventory = new String[20];
    private String[][] userAccounts = new String[20][6];
    private static Library instance = null;
    
    
    private Library() {
    }
    
    public static Library getTheLibrary() {
        if(instance==null) { instance = new Library(); 
        }
            return instance;
        }
    /**
     * 
     * @param newBook
     * @return true if book was added, false otherwise
     */
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
    /**
     * 
     * @param book
     * @return book if book was found, null otherwise
     */
    
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
    /**
     * 
     * @param String book
     * @param String user
     * @return true if book could be returned, false otherwise
     */
    
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
    /**
     * 
     * @param String userAccount
     * @return true if user has an account, false otherwise
     */
    
    public boolean hasUserAccount(String pi) {
        for(String[] s : userAccounts) {
            if(s[0].equals(pi)) {
                return true;
            }
        }
        return false;
    }
    /**
     * 
     * @param String ua
     * @return true if account was added, false otherwise
     */
    public boolean addUserAccount(String ua) {
        if(hasUserAccount(ua)) {
            return false;
        }
        int counter=0;
        for(String[] s : userAccounts) {
            counter++;
        }
        if(counter<20) {
            userAccounts[counter][0] = ua;
                    return true;
        }
        return false;
    }
    
}