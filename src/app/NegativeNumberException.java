package app;

public class NegativeNumberException extends Throwable {
    int val;
    NegativeNumberException(int numThrown) {
        val = numThrown;
    }
    public String getMessage() {
        return "Negatives not allowed: " + val;
    }
}
