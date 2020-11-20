package app;

import java.util.regex.Pattern;
import app.NegativeNumberException;

public class StringCalculator {
    public int Add(String numbers) throws NegativeNumberException{
        int sum;
        String delimiter;
        if (numbers.startsWith("//")) {
            delimiter = "/" + numbers.charAt(2);
        }
        else {
            delimiter = ",";
        }
        String[] arrayOfNumbers = numbers.split("[" + Pattern.quote(delimiter) + "\\n]", 0);
        try {
            sum = calculateSum(arrayOfNumbers);
        } catch (NegativeNumberException e) {
            throw e;
        }

        return sum;
    }

    private int calculateSum(String[] numbers) throws NegativeNumberException {
        int sum = 0, index = 0;
        int num;
        int[] temp = new int[numbers.length];
        try {
            for(String st : numbers) {
                if (!st.equals("")) {
                    num = Integer.parseInt(st);
                    if (num < 0) {
                        temp[index++] = num;
                    }
                    sum += num;
                }
            }

            if (temp[0] < 0) {
                throw new NegativeNumberException(temp);
            }
        } catch (NegativeNumberException e) {
            throw e;
        }
        return sum;
    }
}
