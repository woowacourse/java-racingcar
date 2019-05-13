package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpressionValidatorTest {

    @Test
    void 앞에_숫자_아닌_다른_문자(){
        assertThat(ExpressionValidator.isRightFormat("+ 3 + 3")).isFalse();
    }

    @Test
    void 연속된_부호(){
        assertThat(ExpressionValidator.isRightFormat("10 + * 5")).isFalse();
    }

    @Test
    void 사칙연산_이외의_문자(){
        assertThat(ExpressionValidator.isRightFormat("10 ^ 2")).isFalse();
    }

    @Test
    void 두글자_이하(){
        assertThat(ExpressionValidator.isRightFormat("2")).isFalse();
        assertThat(ExpressionValidator.isRightFormat("2 +")).isFalse();
    }

    @Test
    void 영으로_나누기(){
        assertThat(ExpressionValidator.isDivideZero("10 + 2 / 0")).isFalse();
    }

    @Test
    void 정상_수행() {
        assertThat(ExpressionValidator.isValid("10 + 2 / 6")).isTrue();
    }
}
