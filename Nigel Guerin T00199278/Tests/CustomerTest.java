import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    Customer customer = new Customer("Tom Joe",  43.95);

    @Test
    public void testCustomer() throws Exception {
        Customer joe = new Customer();
        assertEquals("Name unknown",joe.getName());
    }

    @Test
    public void TestGetName() {
        assertEquals("Tom Joe", customer.getName());
    }

    @Test
    public void TestToString() {
        Customer tom = new Customer("tom", 115.16);
        assertEquals(tom.toString(), "Name: " + tom.getName() + " Payments: " + tom.getMonthlypayments());
    }
}