package exceptions;

public class SelectMembreException extends Exception {
    
    public SelectMembreException() {
        super("\n\nErreur de saisi : le membre n'a pas été sélectionné");
    }
    
}
