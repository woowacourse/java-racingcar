package racing.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryCountTest {

    @Test
    @DisplayName("정상적으로 TryCount를 생성합니다.")
    void createTryCount() {
        assertThatCode(() -> new TryCount(5)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("시도 횟수가 0 이하의 숫자인 경우 예외")
    void createTryCountWithUnderZero(int invalidCount) {
        assertThatThrownBy(() -> new TryCount(invalidCount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
