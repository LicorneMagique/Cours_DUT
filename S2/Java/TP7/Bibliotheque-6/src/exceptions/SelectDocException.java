package exceptions;

public class SelectDocException extends Exception {
    
    public SelectDocException() {
        super("\n\nErreur de saisi : le document n'a pas été sélectionné");
    }
    
}
