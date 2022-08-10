package app.util.exceptions;

public class AuthenticationException extends RuntimeException{

    public AuthenticationException() {
        super("Could not find user with provided details!");
    }

    public AuthenticationException(String message) {
        super(message);
    }

    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
