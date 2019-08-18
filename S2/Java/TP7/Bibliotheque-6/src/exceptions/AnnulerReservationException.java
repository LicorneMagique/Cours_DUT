package exceptions;

public class AnnulerReservationException extends Exception {
    
    public AnnulerReservationException() {
        
        super("\n\nOpération impossible : le document n'a pas été réservé");
    }
}
