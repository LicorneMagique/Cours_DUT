package exceptions;

public class EmprunterDocException extends Exception {
    
    public EmprunterDocException() {
        
        super("\n\nOpération impossible : le document n'a pas été emprunté");
    }
}
