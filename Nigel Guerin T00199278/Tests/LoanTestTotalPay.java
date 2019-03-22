import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;

@RunWith(value = Parameterized.class)

public class LoanTestTotalPay {
    private double expected;
    private double loanAmount;
    private int period;

    public LoanTestTotalPay( double loanAmount, int period, double expected) {
        this.loanAmount = loanAmount;
        this.period = period;
        this.expected = expected;
    }
    @Parameterized.Parameters (name= "{index}: checkCost({1})={0}")
    public static Collection<Object[]> getTestParameters() {
        return Arrays.asList(new Object[][] {
                {500,1,527.49},
                {2750,2,3045.56},
                {5000,3,5808.09},
                {5001,1,5220.34},
                {7500,2,8140.91},
                {10000,3,11281.09},
                {500,4,563.64},
                {2750,5,3189.91},
                {5000,4,5636.40},
                {5001,4,5528.13},
                {7500,5,8492.05},
                {10000,5,11322.74},
        });
    }

    @Test
    public void TestGetTotalPayment() {
        Loan loan = new Loan(loanAmount, period);
        assertEquals(expected, loan.getTotalPayment(),1.11);

    }
}
