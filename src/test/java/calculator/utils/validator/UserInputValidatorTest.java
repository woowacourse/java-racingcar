package calculator.utils.validator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserInputValidatorTest {

    @Test
    @DisplayName("커스텀 구분자가 입력된 경우를 잘 검증하는지 테스트")
    void customDelimiterExist() {
        assertThat(UserInputValidator.isCustomDelimiter("//;")).isTrue();
    }

    @Test
    @DisplayName("커스텀 구분자가 입력되지 않은 경우를 잘 검증하는지 테스트")
    void mixDelimiterTest() {
        assertThat(UserInputValidator.isCustomDelimiter("1,2:3")).isFalse();
    }

    @Test
    @DisplayName("공백이 입력된 경우를 잘 검증하는지 테스트")
    void whiteSpaceTest() {
        assertThat(UserInputValidator.isNullOrWhiteSpace("")).isTrue();
    }

    @Test
    @DisplayName("null이 입력된 경우를 잘 검증하는지 테스트")
    void nullTest() {
        assertThat(UserInputValidator.isNullOrWhiteSpace(null)).isTrue();
    }
}