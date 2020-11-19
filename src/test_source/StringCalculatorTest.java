package test_source;

import org.junit.*;

import app.StringCalculator;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {
    public static void test() {
        StringCalculator calc = new StringCalculator();

        // Test 1: No value input
        assertEquals(0, calc.Add(""));

        //Test 2: Single value input
        assertEquals(2, calc.Add("2"));

        //Test 3: Two values input
        assertEquals(5, calc.Add("2,3"));

        //Test 4: Unknown amount of numbers
        assertEquals(10, calc.Add("4,2,3,1"));
        assertEquals(15, calc.Add("3,3,2,7"));

    }


}
