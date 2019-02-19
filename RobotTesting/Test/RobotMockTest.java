import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static junit.framework.TestCase.assertEquals;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.powermock.api.easymock.PowerMock.replay;
import static org.powermock.api.easymock.PowerMock.verify;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Robot.class)
public class RobotMockTest {
    private  RobotFees mockRobotFees;
    @Test
    public void testOwner() throws Exception {
        System.out.println("in test");
        Robot buddy = new Robot("buddy", 1);

        /*call the createMock to create a mock for the Owner class */
        Owner mockOwner = EasyMock.createMock(Owner.class);

        /* Tell PowerMock to intercept any new call and return mockOwner */
        PowerMock.expectNew(Owner.class, "John Smith", 10000.00).andReturn(mockOwner);

        /* set up the expected values and return values */
        expect(mockOwner.getMonthlyPayments()).andReturn(833.33);

        /*activate the mock */
        replay(mockOwner, Owner.class);

        double expResult = 833.33;
        double result = buddy.recordOwnerAndMonthlyPayments("John Smith");
        assertEquals(expResult, result, 0.05);
        /* verify that PowerMock was called and used */
        verify(mockOwner, Owner.class);
    }
    @Test
    public void testGetTotalCost() {

        System.out.println("getTotalCost");

        Robot instance = new Robot("robbie", 5);

        /* Call the createMock to create a mock of the RobotFee class */

        mockRobotFees = createMock("mockRobotFees",RobotFees.class);

        /* Set up the expected values and return values. */
        expect(mockRobotFees.getCost(5)).andReturn(100.00);

        // activate the mock
        replay(mockRobotFees);

        double expResult = 10100.00;

        double result = instance.getTotalCost(mockRobotFees);

        Assert.assertEquals(expResult, result, 0.5);

        /* verify that the mock was used correctly */
        verify(mockRobotFees);
    }
    @Test
    public void testEngineer() throws Exception {
        System.out.println("in test");
        Robot buddy = new Robot("buddy", 1);

        /*call the createMock to create a mock for the Owner class */
        Engineer mockEngineer = EasyMock.createMock(Engineer.class);

        /* Tell PowerMock to intercept any new call and return mockOwner */
        PowerMock.expectNew(Engineer.class, "John", 123456).andReturn(mockEngineer);

        /* set up the expected values and return values */
        expect(mockEngineer.getContactNo()).andReturn(123456);

        /*activate the mock */
        replay(mockEngineer, Engineer.class);

        double expResult = 123456;
        double result = buddy.recordEngineer("John", 123456);
        assertEquals(expResult, result);
        /* verify that PowerMock was called and used */
        verify(mockEngineer, Engineer.class);
    }
}



