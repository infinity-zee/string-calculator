package app;

import java.util.regex.Pattern;

public class StringCalculator {
    public int Add(String numbers) {
        int sum;
        String delimiter;
        if (numbers.startsWith("//")) {
            delimiter = "/" + numbers.charAt(2);
        }
        else {
            delimiter = ",";
        }
        String[] arrayOfNumbers = numbers.split("[" + Pattern.quote(delimiter) + "\\n]", 0);
        sum = calculateSum(arrayOfNumbers);

        return sum;
    }

    private int calculateSum(String[] numbers) {
        int sum = 0;
        for(String st : numbers) {
            if (!st.equals("")) {
                sum += Integer.parseInt(st);
            }
        }
        return sum;
    }
}
