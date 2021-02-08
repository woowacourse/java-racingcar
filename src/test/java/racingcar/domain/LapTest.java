package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LapTest {
    @Test
    @DisplayName("횟수 생성 확인")
    public void lap_create() {
        Lap lap = new Lap("10");
        assertThat(lap.getLap()).isEqualTo(10);
    }

    @Test
    @DisplayName("숫자가 아닌 값을 입력한 경우")
    void lap_not_null() {
        assertThatThrownBy(() -> new Lap("hi")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1보다 작은 값을 입력한 경우")
    void lap_smaller_than_one() {
        assertThatThrownBy(() -> new Lap("0")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("lap이 끝났는지 확인")
    void lap_finish() {
        int testNumber = 5;
        Lap lap = new Lap(Integer.toString(testNumber));
        assertThat(lap.getLap()).isEqualTo(testNumber);

        while (!lap.isFinishAll()) {
            testNumber -= 1;
            lap.finishOneLap();
        }
        assertThat(lap.getLap()).isEqualTo(testNumber);
    }
}