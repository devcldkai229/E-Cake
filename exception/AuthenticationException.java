package devcldkai.kaipizzas.exception;

public abstract class AuthenticationException extends RuntimeException {

    public AuthenticationException(String msg, Throwable cause) {
        super(msg, cause);
    }


    public AuthenticationException(String msg) {
        super(msg);
    }

}