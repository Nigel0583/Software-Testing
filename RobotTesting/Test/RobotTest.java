import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;


import static org.junit.Assert.*;

public class RobotTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(2000);

    Robot buddy = new Robot("buddy", 4);




    @Test
    public void TestGetName() {
        assertEquals("buddy", buddy.getName());
    }

    @Test
    public void TestGetAge() {
        assertEquals(4, buddy.getAge());
    }

    @Test
    public void TestIsNotWorking() {
        assertFalse(buddy.isWorking());
    }

    @Test
    public void TestIsWorking() {
        buddy.talkToRobot();
        assertTrue(buddy.isWorking());
    }

    @Test
    public void TestGetWorkingMessage() {
        buddy.talkToRobot();
        assertEquals("I am in working mode", buddy.getWorkingMessage());
    }

    @Test(expected = IllegalStateException.class)
    public void TestGetWorkingMessageFail() {
        assertEquals("I am in working mode", buddy.getWorkingMessage());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestGetNameFail() {
        Robot chuck = new Robot("", 2);
        assertEquals("", chuck.getWorkingMessage());
    }

    @Test(timeout = 100)//milliseconds
    public void TestWaitTillWorking() {
        buddy.waitTillWorking();
    }
}