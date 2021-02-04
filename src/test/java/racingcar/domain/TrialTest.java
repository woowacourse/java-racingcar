package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TrialTest {
    @ParameterizedTest
    @ValueSource(strings = {"123aa", "a1231", "11a11"})
    void isNumber(String trial) {
        assertThatThrownBy(() -> {
            new Trial(trial);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("시도 횟수는 숫자여야합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    public void isTrialMoreThan1(String trial) {
        assertThatThrownBy(() -> {
            new Trial(trial);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("시도 횟수는 1이상의 양수만 입력가능합니다.");
    }
}
