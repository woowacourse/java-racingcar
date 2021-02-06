package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LapTest {

    @Test
    @DisplayName("횟수 생성 확인")
    public void lap_create() {
        int testNumber = 3;
        Lap lap = new Lap(Integer.toString(testNumber));

        for (int i = 0; i < testNumber; i++) {
            lap.passOneLap();
        }

        assertThat(lap.isFinish()).isTrue();
    }

    @Test
    @DisplayName("숫자가 아닌 값을 입력한 경우")
    void lap_숫자가_아닌_경우_예외처리() {
        assertThatThrownBy(() -> new Lap("hi")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1보다 작은 값을 입력한 경우")
    void lap_1보다_작은_경우_예외처리() {
        assertThatThrownBy(() -> new Lap("0")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("lap이 끝났는지 확인")
    void lap_끝_확인() {
        int testNumber = 5;
        Lap lap = new Lap(Integer.toString(testNumber));

        while (!lap.isFinish()) {
            testNumber -= 1;
            lap.passOneLap();
        }
        assertThat(lap.isFinish()).isTrue();
    }
}