package custom_exceptions;

public class NoStudentException extends RuntimeException {

    public NoStudentException(String errorMessage) {
        super(errorMessage);
    }
//    throw new NoStudentException();
}
