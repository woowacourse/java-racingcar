package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LapTest {
    @Test
    @DisplayName("횟수 생성 확인")
    public void lapCreate() {
        final Lap lap = new Lap("10");
        assertThat(lap.getLap()).isEqualTo(10);
    }

    @Test
    @DisplayName("숫자가 아닌 값을 입력한 경우")
    void lapNotNull() {
        assertThatThrownBy(() -> new Lap("hi")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1보다 작은 값을 입력한 경우")
    void lapSmallerThanOne() {
        assertThatThrownBy(() -> new Lap("0")).isInstanceOf(IllegalArgumentException.class);
    }
}