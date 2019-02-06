import org.junit.Test;

import static org.junit.Assert.*;

public class DriverTestTest {

    Driver driver =new Driver("Bob", 546);

    @Test
    public void TestGetDriverName() {
        assertEquals("Bob", driver.getDriverName());
    }

    @Test
    public void TestGetDriverNum() {
        assertEquals(546, driver.getDriverNum());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestDriverNum() {
        Driver tom = new Driver("tom", 0);
        assertEquals(0, tom.getDriverNum());
    }
    @Test
    public void TestToString() {
        Driver tom = new Driver("tom", 566);
        assertEquals(tom.toString(), "\nDriver Name: " + tom.getDriverName() + "\nDriver Number: " + tom.getDriverNum());
    }

    @Test
    public void TestCheckStatus() {
        assertFalse(driver.check_status());
    }

    @Test(timeout = 1000)//milliseconds
    public void TestWaitTillBanned() {
        driver.waitTillbanned();
    }
}