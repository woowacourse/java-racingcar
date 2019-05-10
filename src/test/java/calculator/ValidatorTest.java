package calculator;


import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class ValidatorTest {

    @Test
    public void 숫자와_연산자가_아닌_경우() {
        assertFalse(new Validator("a + 1").validateForm());
    }

    @Test
    public void 길이가_3미만인_경우() {
        assertFalse(new Validator("1 +").validateLength());
    }

    @Test
    public void 분모가_0인_경우() {
        assertFalse(new Validator("1 / 0").dividedZero());
    }

    @Test
    public void 숫자_순서가_잘못된_경우() {
        assertFalse(new Validator("1 + +").validateOrderOfNumbers());
    }

    @Test
    public void 연산자_순서가_잘못된_경우() {
        assertFalse(new Validator("1 1 +").validateOrderOfOperator());
    }
}