package exception;

public class DuplicateUsernameException extends BaseException {
    public DuplicateUsernameException() {}
    public DuplicateUsernameException(String message) {
        super(message);
    }
}
