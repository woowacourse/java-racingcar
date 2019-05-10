package racingcar.validator;


import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class InputValidatorTest {

    @Test
    public void 자동차_이름이_6글자_이상인_경우() {
        assertFalse(InputValidator.validateAll("abc,abcd,abcde,abcdef"));
    }

    @Test
    public void 자동차_이름에_중복된_쉼표가_있는_경우() {
        assertFalse(InputValidator.validateAll("abc,abcd,abcde,,abcde"));
    }

    @Test
    public void 자동차_이름에_알파벳이_아닌_문자가_포함된_경우() {
        assertFalse(InputValidator.validateAll(" "));
        assertFalse(InputValidator.validateAll(""));
        assertFalse(InputValidator.validateAll("abc#,abcd,abcde,abcd1"));
    }

    @Test
    public void 자동차_이름에_중복된_이름이_있는_경우() {
        assertFalse(InputValidator.validateAll("abc,abcd,abc,abcde"));
    }

    @Test
    public void 시도_횟수가_자연수가_아닌_경우() {
        assertFalse(InputValidator.validateNaturalNumber(""));
        assertFalse(InputValidator.validateNaturalNumber(" "));
        assertFalse(InputValidator.validateNaturalNumber("0"));
        assertFalse(InputValidator.validateNaturalNumber("01"));
        assertFalse(InputValidator.validateNaturalNumber("-1"));
        assertFalse(InputValidator.validateNaturalNumber("sadfsf"));
    }
}