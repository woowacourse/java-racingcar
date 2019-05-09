package racingcar.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test
    void 자동차_이름이_6글자_이상인_경우() {
        assertFalse(InputValidator.validateForm("abc,abcd,abcde,abcdef"));
    }

    @Test
    void 자동차_이름에_중복된_쉼표가_있는_경우() {
        assertFalse(InputValidator.validateForm("abc,abcd,abcde,,abcde"));
    }

    @Test
    void 자동차_이름에_알파벳이_아닌_문자가_포함된_경우() {
        assertFalse(InputValidator.validateForm(" "));
        assertFalse(InputValidator.validateForm(""));
        assertFalse(InputValidator.validateForm("abc#,abcd,abcde,abcd1"));
    }

    @Test
    void 자동차_이름에_중복된_이름이_있는_경우() {
        assertFalse(InputValidator.validateForm("abc,abcd,abc,,abcde"));
    }

    @Test
    void 시도_횟수가_자연수가_아닌_경우() {
        assertFalse(InputValidator.validateNaturalNumber(""));
        assertFalse(InputValidator.validateNaturalNumber(" "));
        assertFalse(InputValidator.validateNaturalNumber("0"));
        assertFalse(InputValidator.validateNaturalNumber("01"));
        assertFalse(InputValidator.validateNaturalNumber("-1"));
        assertFalse(InputValidator.validateNaturalNumber("sadfsf"));
    }
}