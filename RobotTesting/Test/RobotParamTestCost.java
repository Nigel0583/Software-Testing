import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;

@RunWith(value = Parameterized.class)

public class RobotParamTestCost {

    private double expected;
    private int age;

    public RobotParamTestCost(double expected, int age) {
        this.age = age;
        this.expected = expected;
    }
    @Parameterized.Parameters (name= "{index}: checkCost({1})={0}")
    public static Collection<Object[]> getTestParameters() {
        return Arrays.asList(new Object[][] {
                {10000.00,2},
                {10000.00,5},
                {7500.00,10},
                {7500.00,9},
                {5000.00,20},
        });
    }

    @Test
    public void testcheckageAll() {
        Robot buddy = new Robot("buddy", age);
        assertEquals(expected, buddy.checkCost(),0.0);

    }
}
