import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertEquals;
import static org.powermock.api.easymock.PowerMock.verify;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Customer.class)
public class LoanMockTest {

    @Test
    public void testCustomerTakeOutLoan() throws Exception {
        System.out.println("Test take out loan");
        Customer customer = new Customer("Bob");

        /*call the createMock to create a mock for the Loan class */
        Loan mockLoan = createMock(Loan.class);

        /* Tell PowerMock to intercept any new call and return mockLoan */
        PowerMock.expectNew(Loan.class, 5000.0, 5).andReturn(mockLoan);

        /* set up the expected values and return values */
        expect(mockLoan.getMonthlyPayment()).andReturn(96.66);

        /*activate the mock */
        PowerMock.replay(mockLoan, Loan.class);

        double expResult = 96.66;

        customer.takeoutloan();
        double result = customer.getMonthlypayments();
        assertEquals(expResult, result, 0.00);

        /* verify that PowerMock was called and used */
        verify(mockLoan, Loan.class);
    }
}