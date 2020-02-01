package custom_exceptions;

public class NoFacultyException extends RuntimeException {

    public NoFacultyException(String errorMessage) {
        super(errorMessage);
    }
    //    throw new NoFacultyException();
}
