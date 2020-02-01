package custom_exceptions;

public class NoSubjectException extends RuntimeException {

    public NoSubjectException(String errorMessage) {
        super(errorMessage);
    }
//    throw new NoSubjectException();
}
