package example;

import Zadania.Calculator2;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class ParametrizedJUnitParamsCalculatorTest {

    Object data() {
        return new Object[]{
                new Integer[]{new Integer(2),new Integer(2),new Integer (4)},
                new Integer[]{new Integer(1),new Integer(3),new Integer (4)},
                new Integer[]{new Integer(4),new Integer(5),new Integer (9)},
                };
        }

    Calculator2 calculator;
    @Before
    public void before() {
        calculator = new Calculator2();
    }
        @Test
    @Parameters(method = "data")
    @TestCaseName("[{index}] [method]  {0} + {1} = {2}")
    public void testSum(int a,int b,int expectedSum){
        int sum = calculator.sum(a,b);
        assertEquals(expectedSum,sum,0);
    }
}
