package custom_exceptions;

public class NoGroupException extends RuntimeException {

    public NoGroupException(String errorMessage) {
        super(errorMessage);
    }
//    throw new NoGroupException();
}
