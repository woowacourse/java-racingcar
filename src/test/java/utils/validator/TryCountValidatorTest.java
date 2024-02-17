package utils.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryCountValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "4", "13", "123"})
    @DisplayName("시도 횟수가 양의 정수면 정수형으로 정상 파싱된다.")
    void validateCorrectTryCountFormat(String invalidTryCount) {
        Assertions.assertThatNoException()
                .isThrownBy(() -> TryCountValidator.validateTryCountFormat(invalidTryCount));

    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "a", "-1", "0", "@#@!"})
    @DisplayName("시도 횟수가 양의 정수가 아니라면 예외를 발생시킨다")
    void validateInCorrectTryCountFormat(String invalidTryCount) {
        Assertions.assertThatThrownBy(() -> TryCountValidator.validateTryCountFormat(invalidTryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 양의 정수여야만 합니다.");
    }

}