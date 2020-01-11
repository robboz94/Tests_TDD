package example;

import Zadania.Calculator2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Calculator1Test {
    //Calculator1 calculator1;
    Calculator2 calculator;
    @Before
    public void before() {
        calculator = new Calculator2();

    }

    @Test
    public void sum_2plus2_shouldBeEqual4() {

        int sum = calculator.sum(2, 2);
        Assert.assertEquals(4, sum, 0);
    }

    @Test
    public void substract_2minus3_shouldBeEqualminus1() {

        Assert.assertEquals(-1, calculator.substract(2, 3), 0);
    }

    @Test
    public void divide_4by2_shouldBeEqual2() {

        Assert.assertEquals(2, calculator.divide(4, 2), 0);
    }

    @Test
    public void multiply_4by2_shouldBeEqual8() {

        Assert.assertEquals(8, calculator.multiply(4, 2), 0);
    }
}
