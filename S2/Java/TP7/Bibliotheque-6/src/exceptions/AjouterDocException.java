package exceptions;

public class AjouterDocException extends Exception {
    
    public AjouterDocException() {
        
        super("\n\nErreur de saisi : le document n'a pas été ajouté");
    }
}
