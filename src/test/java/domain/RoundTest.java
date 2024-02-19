package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RoundTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "100"})
    @DisplayName("시도 횟수 정상 입력")
    void round_ok(String rawRound) {
        new Round(rawRound);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "101"})
    @DisplayName("시도 횟수 예외 입력: 범위 초과")
    void round_exception_rangeViolation(String rawRound) {
        assertThatThrownBy(() -> new Round(rawRound))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "10!"})
    @DisplayName("시도 횟수 예외 입력: 숫자가 아닌 입력")
    void round_exception_nonNumbers(String rawRound) {
        assertThatThrownBy(() -> new Round(rawRound))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
