import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;

@RunWith(value = Parameterized.class)

public class LoanTestMonthlyPayParam {
    private double expected;
    private double loanAmount;

    private int period;

    public LoanTestMonthlyPayParam(double loanAmount, int period, double expected) {
        this.loanAmount = loanAmount;

        this.period = period;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: checkMonthlyPayment({1})={0}")
    public static Collection<Object[]> getTestParameters() {
        return Arrays.asList(new Object[][]{
                {500, 1, 43.95},
                {2750, 2, 126.89},
                {5000, 3, 161.33},
                {5001, 3, 156.71},
                {7500, 2, 339.20},
                {10000, 3, 313.36},
                {500, 4, 11.74},
                {2750, 5, 53.16},
                {5000, 4, 117.42},
                {5001, 4, 115.16},
                {7500, 5, 141.53},
                {10000, 5, 188.71},

        });
    }

    @Test
    public void TestGetMonthlyPayment() {
        Loan loan = new Loan(loanAmount, period);
        assertEquals(expected, loan.getMonthlyPayment(), 0.11);

    }
}
