package app;

public class NegativeNumberException extends Throwable {
    int[] negativeValues;
    NegativeNumberException(int[] numThrown) {
        negativeValues = numThrown;
    }
    public String getMessage() {
        String message = "Negatives not allowed: ";
        for(int val : negativeValues) {
            if (val < 0) {
                message = message + val + ", ";
            }
        }
        message = message.substring(0, message.length() - 2);
        return message;
    }
}
