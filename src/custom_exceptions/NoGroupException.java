package custom_exceptions;

public class NoGroupException extends RuntimeException {

    @Override
    public String toString() {
        return "NoGroupException";
    }
//    throw new NoGroupException();
}
