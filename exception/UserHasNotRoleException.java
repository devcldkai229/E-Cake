package devcldkai.kaipizzas.exception;

public class UserHasNotRoleException extends AuthenticationException {

    public  UserHasNotRoleException(String msg) {
        super(msg);
    }

    public UserHasNotRoleException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
