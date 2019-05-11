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
    public void 자동차_이름이_빈문자열인_경우() {
        assertFalse(InputValidator.validateAll(""));
    }

    @Test
    public void 자동차_이름이_공백인_경우() {
        assertFalse(InputValidator.validateAll(" "));
    }

    @Test
    public void 자동차_이름에_잘못된_문자열이_포함된_경우() {
        assertFalse(InputValidator.validateAll("abc#,abcd,abcde,abcd1"));
    }

    @Test
    public void 자동차_이름에_중복된_이름이_있는_경우() {
        assertFalse(InputValidator.validateAll("abc,abcd,abc,abcde"));
    }

    @Test
    public void 시도_횟수가_빈문자열인_경우() {
        assertFalse(InputValidator.validateNaturalNumber(""));
    }

    @Test
    public void 시도_횟수가_공백인_경우() {
        assertFalse(InputValidator.validateNaturalNumber(" "));
    }

    @Test
    public void 시도_횟수가_0인_경우() {
        assertFalse(InputValidator.validateNaturalNumber("0"));
    }

    @Test
    public void 시도_횟수가_잘못된_숫자인_경우() {
        assertFalse(InputValidator.validateNaturalNumber("01"));
    }

    @Test
    public void 시도_횟수가_음수인_경우() {
        assertFalse(InputValidator.validateNaturalNumber("-1"));
    }

    @Test
    public void 시도_횟수가_문자열인_경우() {
        assertFalse(InputValidator.validateNaturalNumber("sadfsf"));
    }
}