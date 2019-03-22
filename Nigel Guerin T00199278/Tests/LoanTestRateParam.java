import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;

@RunWith(value = Parameterized.class)

public class LoanTestRateParam {
    private double expected;
    private double loanAmount;

    private int period;

    public LoanTestRateParam(double loanAmount, int period, double expected) {
        this.loanAmount = loanAmount;

        this.period = period;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: checkRate({1})={0}")
    public static Collection<Object[]> getTestParameters() {
        return Arrays.asList(new Object[][]{
                {500, 1, 10},
                {2750, 2, 10},
                {5000, 3, 10},
                {5001, 3, 8},
                {7500, 2, 8},
                {10000, 3, 8},
                {500, 4, 6},
                {2750, 5, 6},
                {5000, 4, 6},
                {5001, 4, 5},
                {7500, 5, 5},
                {10000, 5, 5},

        });
    }

    @Test
    public void TestGetMonthlyPayment() {
        Loan loan = new Loan(loanAmount, period);
        assertEquals(expected, loan.getRate(), 0.0);

    }
}