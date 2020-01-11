package example;

import Zadania.Calculator2;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExceptionsCalculatorTest {
    Calculator2 calculator;

    @Before
    public void before() {
        calculator = new Calculator2();

    }

    @Test
    //Test (expected =)
    public void sum_2plus3_shouldBeEqualminus1() {
        assertEquals(5, calculator.substract(2, 3), 0);
    }

    @Test
    //Test try {} – catch {}

    public void sum_whenAddingDigitandNull_shouldThrowNullPointerException() {
        try {
            calculator.sum(2, null);

        } catch (IllegalArgumentException e) {
            assertEquals("Adding non integer digits", e.getMessage());
        }
    }
    @Test
    public void sum_whenAddingWithIllegalArgument_shouldThrowIllegalArgumentException(){
        Exception exception = assertThrows(IllegalArgumentException.class, ()-> calculator.sum(2,null));
        assertEquals("Adding non integer digits",exception.getMessage());
    }

    @Test
    public void substract_2minus3_shouldBeEqualminus1() {

        assertEquals(-1, calculator.substract(2, 3), 0);
    }

    @Test
    public void divide_whenDividingBy0_shouldThrowArithmeticException() {

        //    Assert.assertEquals(2, calculator.divide(4, 2), 0);
        try {
            calculator.divide(2, 0);
        } catch (ArithmeticException e) {
            assertEquals("Do not divide by 0!", e.getMessage());
        }
    }

    @Test
    public void multiply_4by2_shouldBeEqual8() {

        assertEquals(8, calculator.multiply(4, 2), 0);
    }
}
