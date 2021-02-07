package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TrialTest {
    @ParameterizedTest
    @ValueSource(strings = {"123aa", "a1231", "11a11"})
    void 시도_횟수가_문자로_들어왔을_때(String trial) {
        assertThatThrownBy(() -> {
            new Trial(trial);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("시도 횟수는 숫자여야합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    public void 시도_횟수가_1보다_작거나_숫자가_아닐때(String trial) {
        assertThatThrownBy(() -> {
            new Trial(trial);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("시도 횟수는 1이상의 양수만 입력가능합니다.");
    }
}
