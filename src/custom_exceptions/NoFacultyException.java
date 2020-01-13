package custom_exceptions;

public class NoFacultyException extends RuntimeException {

    @Override
    public String toString() {
        return "NoFacultyException";
    }
//    throw new NoFacultyException();
}
