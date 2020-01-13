package custom_exceptions;

public class NoSubjectException extends RuntimeException {

    @Override
    public String toString() {
        return "NoSubjectException";
    }
//    throw new NoSubjectException();
}
