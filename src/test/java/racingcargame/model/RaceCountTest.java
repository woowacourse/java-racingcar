package racingcargame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceCountTest {

    @DisplayName("입력된 경주횟수가 null인 경우 테스트")
    @Test
    void checkRightCount_InputNullCount() {
        assertThatThrownBy(() -> {
            RaceCount raceCount = new RaceCount(null);
        }).isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining("[error] 경주횟수를 입력해주세요.");
    }

    @DisplayName("입력된 경주횟수가 0~9의 숫자가 아닌 경우 테스트")
    @Test
    void checkRightCount_InputNotRightCountNumber() {
        assertThatThrownBy(() -> {
            RaceCount raceCount = new RaceCount("1_3");
        }).isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining("[error] 경주횟수는 0부터 9까지의 숫자만 입력해주세요.");
    }

    @DisplayName("입력된 경주횟수가 0으로 시작하는 경우 테스트")
    @Test
    void checkRightCount_StartWithZero() {
        assertThatThrownBy(() -> {
            RaceCount raceCount = new RaceCount("073");
        }).isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining("[error] 경주횟수는 1이상의 값을 입력해주세요.");
    }

    @DisplayName("경주횟수가 정상적으로 저장되는지 테스트")
    @Test
    void createObject_RaceCount() {
        RaceCount raceCount = new RaceCount("7");

        assertThat(raceCount.getCount()).isEqualTo(7);
    }

    @DisplayName("경주횟수가 정상적으로 감소하는지 테스트")
    @Test
    void createObject_ReduceRaceCount() {
        RaceCount raceCount = new RaceCount("7");
        raceCount.reduceCount();

        assertThat(raceCount.getCount()).isEqualTo(6);
    }
}
