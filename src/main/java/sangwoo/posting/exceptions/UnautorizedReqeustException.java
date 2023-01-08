package sangwoo.posting.exceptions;

public class UnautorizedReqeustException extends RuntimeException {
    public UnautorizedReqeustException() {
        super();
    }

    public UnautorizedReqeustException(String message) {
        super(message);
    }

    public UnautorizedReqeustException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnautorizedReqeustException(Throwable cause) {
        super(cause);
    }
}
