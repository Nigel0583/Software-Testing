import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;

@RunWith(value = Parameterized.class)

public class LoanNegativeTest {

    @Test(expected = IllegalArgumentException.class)
    public void TestGetAmountFail() {
        Loan chuck = new Loan(0, 0);
        Assert.assertEquals(0, chuck.getAmount(), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestGetPeriod() {
        Loan chuck = new Loan(15000, 6);
        Assert.assertEquals(0, chuck.getAmount(), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestGetRate() {
        Loan chuck = new Loan(450, 2);
        Assert.assertEquals(0, chuck.getRate(), 0.0);
    }

    private double amount;
    private int period;

    public LoanNegativeTest(double amount, int period) {
        this.amount = amount;
        this.period = period;

    }
    @Parameterized.Parameters (name= "{index}: getRate({1})={0}")
    public static Collection<Object[]> getTestParameters() {
        return Arrays.asList(new Object[][] {
                {450, 1},
                {'A', 3 },
                {5000.1, 1},
                {5000.2, 1},
                {5000.3, 1},
                {5000.4, 1},
                {5000.5, 1},
                {5000.6, 1},
                {5000.7, 1},
                {5000.8, 6},
                {5000.9, 1},
                {0, 1}
                /*
                These tests will fail.
               {"ajoe",1},
                {500,"aaa"},
                {500,0}, //Fail
                {null , 1}*/
        });
    }

    @Test (expected = IllegalArgumentException.class)
    public void testCheckGetAmount() {
        Loan loan = new Loan(amount, period);
        assertEquals( loan.getRate(), 0.0 );

    }
}
