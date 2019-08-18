package exceptions;

public class AnnulerReservationException extends Exception {
    
    public AnnulerReservationException() {
        
        super("\n\nOpération impossible : la réservation du document n'a pas été annulée");
    }
}
