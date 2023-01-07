package sangwoo.posting.exceptions;

public class InvalidUserEmailException extends RuntimeException {
    public InvalidUserEmailException() {
        super();
    }

    public InvalidUserEmailException(String message) {
        super(message);
    }

    public InvalidUserEmailException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidUserEmailException(Throwable cause) {
        super(cause);
    }
}
