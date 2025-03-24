package devcldkai.kaipizzas.exception;

public class EmailAlreadyExistException extends AuthenticationException{
    public EmailAlreadyExistException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public EmailAlreadyExistException(String msg) {
        super(msg);
    }
}
