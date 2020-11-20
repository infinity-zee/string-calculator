package app;

public class StringCalculator {
    public int Add(String numbers) {
        int sum;

        String[] arrayOfNumbers = numbers.split("[,\\n]", 0);
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
