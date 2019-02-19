import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

public class DriverScreenOutputTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    /* for console output testing */
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void testDriverNumOkMsg() throws IOException
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Driver buddy = new Driver("Tom", 4999);
        buddy.checkNumberValid();
        baos.flush();
        String whatWasPrinted = new String(baos.toByteArray());
        String[] linesOfOutput = whatWasPrinted.split(//
                System.getProperty("line.separator"));
        assertEquals("Driver number valid", linesOfOutput[0]);
    }

    @Test
    public void testDriverNumNotOkMsg() throws IOException
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Driver buddy = new Driver("Tom", 5001);
        buddy.checkNumberValid();
        baos.flush();
        String whatWasPrinted = new String(baos.toByteArray());
        String[] linesOfOutput = whatWasPrinted.split(//
                System.getProperty("line.separator"));
        assertEquals("Error Driver number not valid", linesOfOutput[0]);
    }

    @After
    /* for console output testing */
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
}

