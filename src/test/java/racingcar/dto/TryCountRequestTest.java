package racingcar.dto;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.exception.ExceptionMessage.ILLEGAL_TRY_COUNT;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryCountRequestTest {

    @ParameterizedTest
    @DisplayName("잘못된 시도 횟수가 검증되어야 한다.")
    @ValueSource(strings = {"-1", "-2", "-3"})
    void validate_illegalTryCount(String input) {
        // expected
        assertThatThrownBy(() -> TryCountRequest.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ILLEGAL_TRY_COUNT.getMessage());
    }

    @ParameterizedTest
    @DisplayName("정상적인 시도 횟수가 검증되어야 한다.")
    @ValueSource(strings = {"0","1","2","3"})
    void validate_tryCount(String input) {
        // expected
        assertThatCode(() -> TryCountRequest.of(input))
                .doesNotThrowAnyException();
    }
}