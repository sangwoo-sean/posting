package sangwoo.posting.exceptions;

public class InvalidUserPasswordException extends RuntimeException {
    public InvalidUserPasswordException() {
        super();
    }

    public InvalidUserPasswordException(String message) {
        super(message);
    }

    public InvalidUserPasswordException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidUserPasswordException(Throwable cause) {
        super(cause);
    }
}
