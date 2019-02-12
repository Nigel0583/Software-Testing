import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;

@RunWith(value = Parameterized.class)

public class RobotParamTests {

    private String expected;
    private int age;

    public RobotParamTests(String expected, int age) {
        this.age = age;
        this.expected = expected;
    }
    @Parameterized.Parameters (name= "{index}: checkage({1})={0}")
    public static Collection<Object[]> getTestParameters() {
        return Arrays.asList(new Object[][] {
                {"Age ok", 10},
                {"Age ok" , 20},
                {"Too old", 25},
        });
    }

    @Test
    public void testcheckageAll() {
        Robot buddy = new Robot("buddy", age);
        assertEquals(expected, buddy.checkage() );

    }
}
