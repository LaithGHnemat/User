package exceptions;

import model.User;

public class NotFoundUserException extends RuntimeException {
    public NotFoundUserException(String msg) {
        super(msg);
    }
}
