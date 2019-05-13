package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidatorTest {

    @Test
    void 앞에_숫자_아닌_다른_문자(){
        assertThat(Validator.isRightFormat("+ 3 + 3")).isFalse();
    }

    @Test
    void 연속된_부호(){
        assertThat(Validator.isRightFormat("10 + * 5")).isFalse();
    }

    @Test
    void 사칙연산_이외의_문자(){
        assertThat(Validator.isRightFormat("10 ^ 2")).isFalse();
    }

    @Test
    void 두글자_이하(){
        assertThat(Validator.isRightFormat("2")).isFalse();
        assertThat(Validator.isRightFormat("2 +")).isFalse();
    }

    @Test
    void 영으로_나누기(){
        assertThat(Validator.isDivideZero("10 + 2 / 0")).isFalse();
    }

    @Test
    void 정상_수행() {
        assertThat(Validator.isValid("10 + 2 / 6")).isTrue();
    }
}
