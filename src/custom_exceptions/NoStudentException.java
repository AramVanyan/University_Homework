package custom_exceptions;

public class NoStudentException extends RuntimeException {

    @Override
    public String toString() {
        return "NoStudentException";
    }
//    throw new NoStudentException();
}
