import static org.junit.Assert.*;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import static org.junit.Assert.*;

public class TestSetDriverNum {

    @Test
    public void testSetDriverNum() throws Exception {
        System.out.println("testSetDriverNum");
        Driver target = new Driver("bob", 5687);
        Class secretClass = target.getClass();

        Field field = secretClass.getDeclaredField("driverNum");

        field.setAccessible(true);

        System.out.println("The value in field (driver) is " + field.get(target));

        int result =  field.getInt(target);
        assertEquals("The driver number should be", 5687,  result);
    }

    @Test
    public void testSetDriverNum1() throws Exception {
        System.out.println("testSetDriverNum1");

        Driver target = new Driver("tom", 5687);

        Method method = Driver.class.getDeclaredMethod("setDriverNum", int.class);

        method.setAccessible(true);

        method.invoke(target, 32145);

        Class secretClass = target.getClass();

        Field field = secretClass.getDeclaredField("driverNum");

        field.setAccessible(true);

        int result =  field.getInt(target);
        System.out.println("The value in field (driverNum) is " + field.get(target));
        assertEquals("The driver number should be equal", 32145,  result);
    }
}



