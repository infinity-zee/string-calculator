package test_source;

import app.NegativeNumberException;
import org.junit.*;

import app.StringCalculator;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {

    public static StringCalculator calc;

    public static void test() {
        calc = new StringCalculator();
        var sct = new StringCalculatorTest();

        try {

            // Test 1: No value input
            assertEquals(0, calc.Add(""));

            //Test 2: Single value input
            assertEquals(2, calc.Add("2"));

            //Test 3: Two values input
            assertEquals(5, calc.Add("2,3"));

            //Test 4: Unknown amount of numbers
            assertEquals(10, calc.Add("4,2,3,1"));
            assertEquals(15, calc.Add("3,3,2,7"));

            //Test 5: Handling newlines along with comma as delimiter
            assertEquals(6, calc.Add("2\n4"));
            assertEquals(18, calc.Add("6,9\n1,2"));

            //Test 6: Test case for values having more than 1 digit
            assertEquals(25, calc.Add("10,12\n3"));

            //Test 7: Test case for different delimiters
            assertEquals(3, calc.Add("//;\n1;2"));
            assertEquals(15, calc.Add("//-\n3-2-10"));

            //Test 8: Test case for negative numbers throwing exception
            sct.testNegativeNumberException();

            //Test 9: Test for multiple negative numbers throwing exception
            sct.testMultipleNegativeNumberException();

            //Test 10: Test case for the GetCalledCount() method
            assertEquals(12, StringCalculator.GetCalledCount());

            //Test 11: Test case with value greater than 1000
            assertEquals(40, calc.Add("12,8,1020,20"));

            //Test 12: Test case for delimiters of variable length
            assertEquals(12, calc.Add("//[^^^]\n2^^^5^^^4^^^1"));

        } catch (NegativeNumberException e) {

        }



    }

    @Test
    public void testNegativeNumberException() {
        try {
            calc.Add("//*\n4*-2*3");
        } catch(NegativeNumberException e) {
            assertEquals("Negatives not allowed: -2", e.getMessage());
        }
    }

    @Test
    public void testMultipleNegativeNumberException() {
        try {
            calc.Add("//$\n4$-2$5$-1$-6$12");
        } catch (NegativeNumberException e) {
            assertEquals("Negatives not allowed: -2, -1, -6", e.getMessage());
        }
    }
}
