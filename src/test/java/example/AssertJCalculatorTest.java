package example;

/*
Napisz testy dla metody divide (Integer a, Integer b) klasy Calculator wykorzystując asercje z biblioteki AssertJ:
-standardowe dzielenie
-sytuacja gdy rzucany jest wyjątek
 */


import Zadania.Calculator2;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class AssertJCalculatorTest {
    Calculator2 calculator;

    @Before
    public void before() {
        calculator = new Calculator2();

    }

    @Test
//  #1  Standardowe dzielenie
    public void divide_4by2_shouldBeEqual2() {
        assertThat(calculator.divide(4, 2)).isEqualTo(2);
    }

    @Test
    public void divide_whenDividingByZero_shouldThrowArithmeticException() {
        /*
         Exception exception = assertThrows(IllegalArgumentException.class, ()-> calculator.sum(2,null));
        assertEquals("Adding non integer digits",exception.getMessage());
         */
       assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculator.divide(null,0);
                }).withMessage("Zle dane");

    }
    @Test
    public void sum_whenNullArgumentIsProvided_shouldThrowIllegalArgumentException() {
        /*
         Exception exception = assertThrows(IllegalArgumentException.class, ()-> calculator.sum(2,null));
        assertEquals("Adding non integer digits",exception.getMessage());
         */
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculator.sum(null,0);
                }).withMessage("Adding non integer digits");

    }

}
