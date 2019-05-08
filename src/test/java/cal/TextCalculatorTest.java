package cal;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TextCalculatorTest {
    private TextCalculator textCalculator;

    @Before
    public void setup(){
        textCalculator = new TextCalculator();
    }

    @Test
    public void 덧셈(){
        assertEquals(3.0, textCalculator.calculate("1 + 2"), 0.00);
    }

    @Test
    public void 뺄셈() {
        assertEquals(2.0, textCalculator.calculate("3 - 1"), 0.0);
    }

    @Test
    public void 곱셈() {
        assertEquals(9, textCalculator.calculate("3 * 3"), 0.0);
    }

    @Test
    public void 나눗셈() {
        assertEquals(10.0, textCalculator.calculate("100 / 10"), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 숫자가아님() {
        textCalculator.calculate("2 + o");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 첫문자가_숫자가아님(){
        textCalculator.calculate("+ 2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 연속_숫자(){
        textCalculator.calculate("2 2 2");
    }

    @Test
    public void 음수(){
        assertEquals(0,textCalculator.calculate("2 + -2"),0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 공백_잘못됨(){
        textCalculator.calculate("2+1");
    }

}