package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class ValidatorTest {

    @Test
    void 숫자와_연산자가_아닌_경우() {
        String value = "a + 1";
        assertFalse(new Validator(value, value.split(" ")).validateForm());
    }

    @Test
    void 길이가_3미만인_경우() {
        String value = "1 +";
        assertFalse(new Validator(value, value.split(" ")).validateLength());
    }

    @Test
    void 분모가_0인_경우() {
        String value = "1 / 0";
        assertFalse(new Validator(value, value.split(" ")).dividedZero());
    }

    @Test
    void 숫자_순서가_잘못된_경우() {
        String value = "1 + +";
        assertFalse(new Validator(value, value.split(" ")).validateOrderOfNumbers());
    }

    @Test
    void 연산자_순서가_잘못된_경우() {
        String value = "1 1 +";
        assertFalse(new Validator(value, value.split(" ")).validateOrderOfOperator());
    }
}