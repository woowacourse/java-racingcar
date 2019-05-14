package calculator.view;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputValidatorTest {

    @Test
    void 숫자인지_확인한다(){
        assertThat(InputValidator.isNumber("5")).isTrue();
        assertThat(InputValidator.isNumber("-1234")).isFalse();
        assertThat(InputValidator.isNumber("0")).isTrue();
        assertThat(InputValidator.isNumber("qweacxz")).isFalse();
        assertThat(InputValidator.isNumber("+")).isFalse();
        assertThat(InputValidator.isNumber("/////")).isFalse();
        assertThat(InputValidator.isNumber(" ")).isFalse();
    }

    @Test
    void 연산자인지_확인한다(){
        assertThat(InputValidator.isOperator("+")).isTrue();
        assertThat(InputValidator.isOperator("-")).isTrue();
        assertThat(InputValidator.isOperator("*")).isTrue();
        assertThat(InputValidator.isOperator("/")).isTrue();
        assertThat(InputValidator.isOperator("++++")).isFalse();
        assertThat(InputValidator.isOperator(" ")).isFalse();
        assertThat(InputValidator.isOperator("asdfqwer")).isFalse();
        assertThat(InputValidator.isOperator("1292")).isFalse();
    }

    @Test
    void 인덱스가_짝수면_숫자_홀수면_연산자인지_검사한다(){
        assertThat(InputValidator.isOperatorOrNumberByIndex("1 + 2 - 3 * 4 / 5".split(" "),0)).isTrue();
        assertThat(InputValidator.isOperatorOrNumberByIndex("+ 1 2 - 3 * 4 / 5".split(" "),0)).isFalse();
        assertThat(InputValidator.isOperatorOrNumberByIndex("1 + 2 - 3 * 4 / 5".split(" "),1)).isTrue();
        assertThat(InputValidator.isOperatorOrNumberByIndex("1 2 2 - 3 * 4 / 5".split(" "),1)).isFalse();
        assertThat(InputValidator.isOperatorOrNumberByIndex("1 + 2 - 3 * 4 / 5".split(" "),2)).isTrue();
        assertThat(InputValidator.isOperatorOrNumberByIndex("1 + * - 3 * 4 / 5".split(" "),2)).isFalse();
    }

    @Test
    void 올바른_입력_순서인지_검사한다(){
        assertThat(InputValidator.isRightSequence("1 + 2 - 3".split(" "))).isTrue();
        assertThat(InputValidator.isRightSequence("1+2-3".split(" "))).isFalse();
        assertThat(InputValidator.isRightSequence("1".split(" "))).isTrue();
        assertThat(InputValidator.isRightSequence("* + s - 3".split(" "))).isFalse();
        assertThat(InputValidator.isRightSequence("1 + /".split(" "))).isFalse();
    }

    @Test
    void 올바른_입력인지_검사한다(){
        assertThat(InputValidator.isValid("1 + 2 / 3 * 4".split(" "))).isTrue();
        assertThat(InputValidator.isValid("+ 1 - 2 * 3".split(" "))).isFalse();
        assertThat(InputValidator.isValid("1  + 2".split(" "))).isFalse();
        assertThat(InputValidator.isValid("123 * 100".split(" "))).isTrue();
        assertThat(InputValidator.isValid("1234".split(" "))).isTrue();
    }
}
