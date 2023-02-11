package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RepeatCountValidatorTest {

    private Validator repeatCountValidator;

    @DisplayName("반복 횟수 입력 실패 1미만 100초과")
    @ParameterizedTest
    @ValueSource(strings = {"0", "101", "-1"})
    void validateRange(String input) {
        repeatCountValidator = new RepeatCountValidator();

        assertThatThrownBy(() -> repeatCountValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 이상만 가능합니다.");
    }

    @DisplayName("반복 횟수 입력 실패 숫자 이외의값")
    @ParameterizedTest
    @ValueSource(strings = {"a", " ", "가", "@", ""})
    void validateNumber(String input) {
        repeatCountValidator = new RepeatCountValidator();

        assertThatThrownBy(() -> repeatCountValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력 가능합니다.");
    }
}