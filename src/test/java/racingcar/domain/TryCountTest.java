package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryCountTest {
    @ParameterizedTest(name = "{displayName} {index} ==> engine : ''{0}''")
    @ValueSource(ints = {0, -1})
    @DisplayName("시도횟수가 0보다 작을 경우 예외 발생")
    void Should_Exception_When_TryCountLessThan0(int tryCount) {
        assertThatThrownBy(() -> new TryCount(tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 시도할 횟수는 0보다 큰 숫자여야 합니다.");
    }

    @ParameterizedTest(name = "{displayName} {index} ==> engine : ''{0}''")
    @ValueSource(ints = {1, 2})
    @DisplayName("시도횟수가 0보다 클 경우 성공")
    void Should_Success_When_TryCountMoreThan0(int tryCount) {
        assertThat(new TryCount(tryCount).getValue()).isEqualTo(tryCount);
    }
}
