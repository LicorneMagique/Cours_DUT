package exceptions;

public class NombreHorsLimiteException extends Exception {
    
    public NombreHorsLimiteException(int nombre) {
        
        super("\n\nErreur de saisi : " + nombre + " est hors limite");
    }
}
