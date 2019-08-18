package exceptions;

public class RetournerDocException extends Exception {
    
    public RetournerDocException() {
        
        super("\n\nOpération impossible : le document n'a pas été retourné");
    }
}
