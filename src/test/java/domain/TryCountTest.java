package domain;

import error.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("시도 횟수는")
class TryCountTest {

    @DisplayName("0회 이하이면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -100})
    void test_fail(int value) {
        assertThatThrownBy(() -> new TryCount(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_COUNT.getValue());
    }

    @DisplayName("1회 이상이면 통과한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 100})
    void test_success(int value) {
        assertDoesNotThrow(() -> new TryCount(value));
    }
}