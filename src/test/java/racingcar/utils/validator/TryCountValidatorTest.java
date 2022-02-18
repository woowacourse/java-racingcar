package racingcar.utils.validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TryCountValidatorTest {

    @Test
    @DisplayName("시도 횟수가 문자일 경우 에러 발생 테스트")
    void validateTryCountNotNumber() {
        String tryCount = "q";
        assertThatThrownBy(() -> {
            TryCountValidator.validateTryCount(tryCount);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 시도 횟수는 양수만 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0"})
    @DisplayName("시도 횟수가 음수 혹은 0일 경우 에러 발생 테스트")
    void validateTryCountZeroAndNegative(String tryCount) {
        assertThatThrownBy(() -> {
            TryCountValidator.validateTryCount(tryCount);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 시도 횟수는 양수만 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("시도 횟수가 null 혹은 공백일 경우 에러 발생 테스트")
    void validateNullAndBlank(String tryCount) {
        assertThatThrownBy(() -> {
            TryCountValidator.validateTryCount(tryCount);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 시도 횟수는 양수만 가능합니다.");
    }
}
