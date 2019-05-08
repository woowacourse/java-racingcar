package calculator.view;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidatorTest {

    @Test
    void 숫자인지_확인한다(){
        assertThat(Validator.isNumber("5")).isEqualTo(true);
        assertThat(Validator.isNumber("-1234")).isEqualTo(true);
        assertThat(Validator.isNumber("0")).isEqualTo(true);
        assertThat(Validator.isNumber("qweacxz")).isEqualTo(false);
        assertThat(Validator.isNumber("+")).isEqualTo(false);
        assertThat(Validator.isNumber("/////")).isEqualTo(false);
        assertThat(Validator.isNumber(" ")).isEqualTo(false);
    }

    @Test
    void 연산자인지_확인한다(){
        assertThat(Validator.isOperator("+")).isEqualTo(true);
        assertThat(Validator.isOperator("-")).isEqualTo(true);
        assertThat(Validator.isOperator("*")).isEqualTo(true);
        assertThat(Validator.isOperator("/")).isEqualTo(true);
        assertThat(Validator.isOperator("++++")).isEqualTo(false);
        assertThat(Validator.isOperator(" ")).isEqualTo(false);
        assertThat(Validator.isOperator("asdfqwer")).isEqualTo(false);
        assertThat(Validator.isOperator("1292")).isEqualTo(false);
    }

    @Test
    void 인덱스가_짝수면_숫자_홀수면_연산자인지_검사한다(){
        assertThat(Validator.isOperatorOrNumberByIndex("1 + 2 - 3 * 4 / 5".split(" "),0)).isEqualTo(true);
        assertThat(Validator.isOperatorOrNumberByIndex("+ 1 2 - 3 * 4 / 5".split(" "),0)).isEqualTo(false);
        assertThat(Validator.isOperatorOrNumberByIndex("1 + 2 - 3 * 4 / 5".split(" "),1)).isEqualTo(true);
        assertThat(Validator.isOperatorOrNumberByIndex("1 2 2 - 3 * 4 / 5".split(" "),1)).isEqualTo(false);
        assertThat(Validator.isOperatorOrNumberByIndex("1 + 2 - 3 * 4 / 5".split(" "),2)).isEqualTo(true);
        assertThat(Validator.isOperatorOrNumberByIndex("1 + * - 3 * 4 / 5".split(" "),2)).isEqualTo(false);
    }

    @Test
    void 올바른_입력_순서인지_검사한다(){
        assertThat(Validator.isRightSequence("1 + 2 - 3".split(" "))).isEqualTo(true);
        assertThat(Validator.isRightSequence("1+2-3".split(" "))).isEqualTo(false);
        assertThat(Validator.isRightSequence("1".split(" "))).isEqualTo(true);
        assertThat(Validator.isRightSequence("* + s - 3".split(" "))).isEqualTo(false);
        assertThat(Validator.isRightSequence("1 + /".split(" "))).isEqualTo(false);
    }

    @Test
    void 올바른_입력인지_검사한다(){
        assertThat(Validator.isValid("1 + 2 / 3 * 4".split(" "))).isEqualTo(true);
        assertThat(Validator.isValid("+ 1 - 2 * 3".split(" "))).isEqualTo(false);
        assertThat(Validator.isValid("1  + 2".split(" "))).isEqualTo(false);
        assertThat(Validator.isValid("123 * 100".split(" "))).isEqualTo(true);
        assertThat(Validator.isValid("1234".split(" "))).isEqualTo(true);
    }


}
