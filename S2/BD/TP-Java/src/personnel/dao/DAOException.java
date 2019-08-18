package personnel.dao;
public class DAOException extends Exception {
    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }
    public DAOException(Throwable cause) {
        super(cause);
    }
}
