package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TrialTest {
    @ParameterizedTest
    @ValueSource(strings = {"123aa", "a1231", "11a11"})
    @DisplayName("시도 횟수가 숫자로 들어오지 않은 경우 예외처리")
    void checkNumber(String trial) {
        assertThatThrownBy(() -> {
            new Trial(trial);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("시도 횟수는 숫자여야합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    @DisplayName("시도 횟수가 1이상의 양수가 아닌 경우 예외처리")
    public void trialMoreThan1(String trial) {
        assertThatThrownBy(() -> {
            new Trial(trial);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("시도 횟수는 1이상의 양수만 입력가능합니다.");
    }
}
