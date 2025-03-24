package devcldkai.kaipizzas.exception;

public class VerifyException extends RuntimeException{

    public VerifyException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public VerifyException(String msg) {
        super(msg);
    }
}
