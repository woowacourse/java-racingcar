package calculator.validator;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidatorTest {

    @Test
    public void 숫자와_연산자가_아닌_경우() {
        assertFalse(Validator.validateAll("a + 1"));
    }

    @Test
    public void 길이가_3미만인_경우() {
        assertFalse(Validator.validateAll("1 +"));
    }

    @Test
    public void 분모가_0인_경우() {
        assertFalse(Validator.validateAll("1 / 0"));
    }

    @Test
    public void 숫자_순서가_잘못된_경우() {
        assertFalse(Validator.validateAll("1 + +"));
    }

    @Test
    public void 연산자_순서가_잘못된_경우() {
        assertFalse(Validator.validateAll("1 1 +"));
    }

    @Test
    public void 정상적인_입력() {
        assertTrue(Validator.validateAll("1 + 1000"));
    }
}