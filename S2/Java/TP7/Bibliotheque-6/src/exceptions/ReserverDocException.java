package exceptions;

public class ReserverDocException extends Exception {
    
    public ReserverDocException() {
        
        super("\n\nOpération impossible : le document n'a pas été réservé");
    }
}
