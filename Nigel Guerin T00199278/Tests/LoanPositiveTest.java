import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;

@RunWith(value = Parameterized.class)

public class LoanPositiveTest {

    private double amount;
    private int period;
    private int expected;

    public LoanPositiveTest(double amount, int period, int expected) {
        this.amount = amount;
        this.period = period;
        this.expected = expected;
    }
    @Parameterized.Parameters (name= "{index}: getAmount({1})={0}")
    public static Collection<Object[]> getTestParameters() {
        return Arrays.asList(new Object[][] {
                {500, 1, 10},
                {10000, 3, 8},
                {2750, 4, 6},
                {5001, 5, 5},
                {9500, 2, 8},
        });
    }

    @Test
    public void testCheckGetAmount() {
        Loan loan = new Loan(amount, period);
        assertEquals(expected, loan.getRate(), 0.0 );

    }

}
