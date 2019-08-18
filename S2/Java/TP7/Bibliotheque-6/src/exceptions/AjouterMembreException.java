package exceptions;

public class AjouterMembreException extends Exception {
    
    public AjouterMembreException() {
        super("\n\nErreur de saisi : le membre n'a pas été crée");
    }
    
}
