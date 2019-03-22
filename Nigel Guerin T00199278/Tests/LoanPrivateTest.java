import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

public class LoanPrivateTest {
    @Test
    public void testSetAmount() throws Exception {
        System.out.println("setAmount");
        /* Set up a new Loan */
        Loan target = new Loan(500, 1);

        /* get the setAmount method details */
        Method method = Loan.class.getDeclaredMethod("setAmount", double.class);

        /* make the method assessable */
        method.setAccessible(true);

        /* invoke the method setAmount with the value 500 */
        method.invoke(target, 500);

        /*access the field amount and check its value is set to 500*/
        Class secretClass = target.getClass();

        Field f = secretClass.getDeclaredField("loanAmount");

        f.setAccessible(true);

        double result = f.getDouble(target);
        System.out.println("The value in f (loanAmount) is " + f.get(target));
        assertEquals("The value should be equal", 500, result, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetAmountFail() throws Exception {
        System.out.println("setAmount IllegalArgumentException");
        /* Set up a new Robot */
        Loan target = new Loan(-1, 1);

        /* get the setAmount method details */
        Method method = Loan.class.getDeclaredMethod("setAmount", double.class);

        /* make the method assessable */
        method.setAccessible(true);

        /* invoke the method setAmount with the value -1 */
        method.invoke(target, -1);

        /*access the field amount and check its value is set to -1*/
        Class secretClass = target.getClass();

        Field f = secretClass.getDeclaredField("loanAmount");

        f.setAccessible(true);

        double result = f.getDouble(target);
        System.out.println("The value in f (loanAmount) is " + f.get(target));
        assertEquals("The value should be equal", 500, result, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetAmountFailUpper() throws Exception {
        System.out.println("setAmount IllegalArgumentException");
        /* Set up a new Loan */
        Loan target = new Loan(10001, 1);

        /* get the setAmount method details */
        Method method = Loan.class.getDeclaredMethod("setAmount", double.class);

        /* make the method assessable */
        method.setAccessible(true);

        /* invoke the method setAmount with the value 10001 */
        method.invoke(target, 10001);

        /*access the field amoounr and check its value is set to 10001*/
        Class secretClass = target.getClass();

        Field f = secretClass.getDeclaredField("loanAmount");

        f.setAccessible(true);

        double result = f.getDouble(target);
        System.out.println("The value in f (loanAmount) is " + f.get(target));
        assertEquals("The value should be equal", 500, result, 0.0);
    }

    @Test
    public void testSetRate() throws Exception {
        System.out.println("setRate");
        /* Set up a new Loan */
        Loan target = new Loan(550, 3);

        /* get the setAge method details */
        Method method = Loan.class.getDeclaredMethod("setRate", int.class);

        /* make the method assessable */
        method.setAccessible(true);

        /* invoke the method setRate with the value 3 */
        method.invoke(target, 3);

        /*access the field period and check its value is set to 3*/
        Class secretClass = target.getClass();

        Field f = secretClass.getDeclaredField("annualRate");

        f.setAccessible(true);

        double result = f.getDouble(target);
        System.out.println("The value in f (annualRate) is " + f.get(target));
        assertEquals("The value should be equal", 10, result, 0.0);
    }

    @Test
    public void testSetRate1() throws Exception {
        System.out.println("setRate");
        /* Set up a new Loan */
        Loan target = new Loan(550, 4);

        /* get the setRate method details */
        Method method = Loan.class.getDeclaredMethod("setRate", int.class);

        /* make the method assessable */
        method.setAccessible(true);

        /* invoke the method setRate with the value 4*/
        method.invoke(target, 4);

        /*access the field period and check its value is set to 4*/
        Class secretClass = target.getClass();

        Field f = secretClass.getDeclaredField("annualRate");

        f.setAccessible(true);

        double result = f.getDouble(target);
        System.out.println("The value in f (annualRate) is " + f.get(target));
        assertEquals("The value should be equal", 6, result, 0.0);
    }

    @Test
    public void testSetRate2() throws Exception {
        System.out.println("setRate");
        /* Set up a new Loan */
        Loan target = new Loan(5539, 3);

        /* get the setRate method details */
        Method method = Loan.class.getDeclaredMethod("setRate", int.class);

        /* make the method assessable */
        method.setAccessible(true);

        /* invoke the method setRate with the value 3 */
        method.invoke(target, 3);

        /*access the field period and check its value is set to 3*/
        Class secretClass = target.getClass();

        Field f = secretClass.getDeclaredField("annualRate");

        f.setAccessible(true);

        double result = f.getDouble(target);
        System.out.println("The value in f (annualRate) is " + f.get(target));
        assertEquals("The value should be equal", 8, result, 0.0);
    }

    @Test
    public void testSetRate3() throws Exception {
        System.out.println("setRate");
        /* Set up a new Loan */
        Loan target = new Loan(5539, 5);

        /* get the setRate method details */
        Method method = Loan.class.getDeclaredMethod("setRate", int.class);

        /* make the method assessable */
        method.setAccessible(true);

        /* invoke the method setRate with the value 5*/
        method.invoke(target, 5);

        /*access the field period and check its value is set to 5*/
        Class secretClass = target.getClass();

        Field f = secretClass.getDeclaredField("annualRate");

        f.setAccessible(true);

        double result = f.getDouble(target);
        System.out.println("The value in f (annualRate) is " + f.get(target));
        assertEquals("The ages value be equal", 5, result, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetRateFail() throws Exception {
        System.out.println("setRate IllegalArgumentException");
        /* Set up a new Loan */
        Loan target = new Loan(499, 6);

        /* get the setRate method details */
        Method method = Loan.class.getDeclaredMethod("setRate", int.class);

        /* make the method assessable */
        method.setAccessible(true);

        /* invoke the method setAge with the value 6 */
        method.invoke(target, 6);

        /*access the field age and check its value is set to 6*/
        Class secretClass = target.getClass();

        Field f = secretClass.getDeclaredField("annualRate");

        f.setAccessible(true);

        double result = f.getDouble(target);
        System.out.println("The value in f (annualRate) is " + f.get(target));
        assertEquals("The ages value be equal", 10, result, 0.0);
    }

    @Test
    public void testMonthRate() throws Exception {
        System.out.println("setRate");
        /* Set up a new Loan */
        Loan target = new Loan(5000, 4);

        /* get the setRate method details */
        Method method = Loan.class.getDeclaredMethod("setRate", int.class);

        /* make the method assessable */
        method.setAccessible(true);

        /* invoke the method setAge with the value 4 */
        method.invoke(target, 4);

        /*access the field period and check its value is set to 4*/
        Class secretClass = target.getClass();

        Field f = secretClass.getDeclaredField("monthlyInterestRate");

        f.setAccessible(true);

        double result = f.getDouble(target);
        System.out.println("The value in f (monthlyInterestRate) is " + f.get(target));
        assertEquals("The value should be equal", 0.005, result, 0.0);
    }

    @Test
    public void testSetPeriod() throws Exception {
        System.out.println("setPeriod");
        /* Set up a new Loan */
        Loan target = new Loan(1000, 4);

        /* get the setPeriod method details */
        Method method = Loan.class.getDeclaredMethod("setPeriod", int.class);

        /* make the method assessable */
        method.setAccessible(true);

        /* invoke the method setPeriod with the value 4 */
        method.invoke(target, 4);

        /*access the field period and check its value is set to 4*/
        Class secretClass = target.getClass();

        Field f = secretClass.getDeclaredField("numberOfPayments");

        f.setAccessible(true);

        double result = f.getDouble(target);
        System.out.println("The value in f (numberOfPayments) is " + f.get(target));
        assertEquals("The value should be equal", 48, result, 0.0);
    }
}

