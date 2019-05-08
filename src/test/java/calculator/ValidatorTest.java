package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void 숫자와_연산자가_아닌_경우() {
        assertFalse(new Validator("a + 1").validateForm());
    }

    @Test
    void 길이가_3미만인_경우() {
        assertFalse(new Validator("1 +").validateLength());
    }

    @Test
    void 분모가_0인_경우() {
        assertFalse(new Validator("1 / 0").dividedZero());
    }

    @Test
    void 숫자_순서가_잘못된_경우() {
        assertFalse(new Validator("1 + +").validateOrderOfNumbers());
    }

    @Test
    void 연산자_순서가_잘못된_경우() {
        assertFalse(new Validator("1 1 +").validateOrderOfOperator());
    }
}