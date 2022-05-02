package exceptions;

public class InvalidMobileException extends RuntimeException {
    public InvalidMobileException(String message) {
        super(message);
    }
}
