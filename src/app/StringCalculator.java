package app;

public class StringCalculator {
    public int Add(String numbers) {
        int sum;

        char[] arrayOfNumbers = numbers.replaceAll(",", "").toCharArray();
        sum = calculateSum(arrayOfNumbers);

        return sum;
    }

    private int calculateSum(char[] numbers) {
        int sum = 0;
        for(char ch : numbers) {
            sum += Character.getNumericValue(ch);
        }
        return sum;
    }
}
