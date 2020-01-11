package example;

import Zadania.Calculator2;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class ParametrizedJUnitFieldsCalculatorTest {
    @Parameterized.Parameter()
    public int a;
    @Parameterized.Parameter(1)
    public int b;
    @Parameterized.Parameter(2)
    public int expectedSum;

    @Parameterized.Parameters(name = "[{index}]  {0} + {1} = {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{{2, 2, 4}, {1, 3, 4}, {4, 5, 9}});
    }
    Calculator2 calculator;
    @Before
    public void before() {
        calculator = new Calculator2();
    }
    @Test
    public void testSum(){
        int sum = calculator.sum(a,b);
        assertEquals(expectedSum,sum,0);
    }
}
