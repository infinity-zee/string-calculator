package app;

import java.util.regex.Pattern;
import app.NegativeNumberException;

public class StringCalculator {

    private static int count = 0;

    public int Add(String numbers) throws NegativeNumberException{
        count++;
        int sum;
        String delimiter;

        String[] arrayOfNumbers = extractArrayOfNumbers(numbers);
        try {
            sum = calculateSum(arrayOfNumbers);
        } catch (NegativeNumberException e) {
            throw e;
        }

        return sum;
    }

    private String[] extractArrayOfNumbers(String numbers) {
        String[] arrayOfNumbers;

        if (numbers.length() != 0 && numbers.charAt(0) == '/') {

            numbers = numbers.replaceAll("/", "");
            String[] temp = numbers.split("[\\n]", 0);
            temp[0] = temp[0].replaceAll("\\[", "(");
            temp[0] = temp[0].replaceAll("]", ")");


            arrayOfNumbers = temp[1].split("[" + temp[0] + ",\n]" , 0);
        }
        else {
            arrayOfNumbers = numbers.split("[,\n]", 0);
        }


        return arrayOfNumbers;
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
                    else if (num < 1000) {
                        sum += num;
                    }
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

    public static int GetCalledCount() {
        return count;
    }
}
