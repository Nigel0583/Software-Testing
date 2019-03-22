import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoanTest {

    Loan loan = new Loan(7500, 2);

    @Test
    public void testLoanConstructor() {
        new Loan();
    }

    @Test (expected = IllegalArgumentException.class)
    public void testLoan()  {
        Loan loan1 = new Loan(-1,3);
    }

    @Test
    public void testGetAmount() {
        assertEquals(7500, loan.getAmount(), 0.0);
    }

    @Test
    public void testGetPeriod() {
        assertEquals(2, loan.getPeriod(), 0.0);
    }

    @Test
    public void testGetRate() {
        assertEquals(8, loan.getRate(), 0.0);
    }

    @Test
    public void testGetMonthlyPayment() {
        assertEquals(339.20, loan.getMonthlyPayment(), 1.11);
    }

    @Test
    public void testGetTotalPayment() {
        assertEquals(8140.91, loan.getTotalPayment(), 1.11);
    }
}

