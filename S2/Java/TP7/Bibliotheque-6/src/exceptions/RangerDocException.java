package exceptions;

public class RangerDocException extends Exception {
    
    public RangerDocException() {
        
        super("\n\nOpération impossible : le document n'a pas été rangé");
    }
}
