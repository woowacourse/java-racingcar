package cal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TextCalculatorTest {
    @Test
    public void 덧셈() {
        assertEquals(3.0, new TextCalculator("1 + 2").calculate(), 0.00);
    }

    @Test
    public void 뺄셈() {
        assertEquals(2.0, new TextCalculator("3 - 1").calculate(), 0.0);
    }

    @Test
    public void 곱셈() {
        assertEquals(9, new TextCalculator("3 * 3").calculate(), 0.0);
    }

    @Test
    public void 나눗셈() {
        assertEquals(10.0, new TextCalculator("100 / 10").calculate(), 0.0);
    }

    @Test
    public void 여러가지_연산() {
        assertEquals(10.0, new TextCalculator("2 + 3 * 4 / 2").calculate(), 0.00);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 숫자가아님() {
        new TextCalculator("2 + o").calculate();
    }

    @Test(expected = IllegalArgumentException.class)
    public void 첫문자가_숫자가아님() {
        new TextCalculator("+ 3 * 4 / 2").calculate();
    }

    @Test(expected =  NullPointerException.class)
    public void 연속_숫자() {
        new TextCalculator(" 3 4 2").calculate();
    }

    @Test
    public void 음수() {
        assertEquals(0, new TextCalculator("2 + -2").calculate(), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 공백_잘못됨() {
        new TextCalculator("2+3 * 4 / 2").calculate();
    }

}