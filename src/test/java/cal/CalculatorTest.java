package cal;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private Calculator cal;

    @Before
    public void setup() {
        cal = new Calculator();
        System.out.println("setup");
    }

    @Test
    public void 덧셈() {
        Assert.assertEquals(3, cal.plus(1, 2));
    }

    @Test
    public void 뺄셈() {
        Assert.assertEquals(-1, cal.minus(1, 2));
    }

    @After
    public void tearDown() {
        System.out.println("tearDown");
    }
}