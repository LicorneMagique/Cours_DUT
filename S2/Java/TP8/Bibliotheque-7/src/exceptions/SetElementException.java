package exceptions;

public class SetElementException extends Exception {
    
    public SetElementException() {
        
        super("\n\nErreur de saisi : l'élément n'a pas changé");
    }
}
