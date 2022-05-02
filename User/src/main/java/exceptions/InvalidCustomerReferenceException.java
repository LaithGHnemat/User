package exceptions;

public class InvalidCustomerReferenceException extends RuntimeException {
    public InvalidCustomerReferenceException(String message) {
        super(message);
    }
}
