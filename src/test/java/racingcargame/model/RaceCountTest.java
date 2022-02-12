package racingcargame.model;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceCountTest {

    @Test
    @DisplayName("저장된 자동차 경주 횟수 확인")
    void storeRaceCount() {
        RacingCarGame racingCarGame = new RacingCarGame(Arrays.asList("a", "b", "c"), 4);

        assertThat(RaceCount.getCount()).isEqualTo(4);
    }

    @Test
    @DisplayName("경주 횟수 감소 테스트")
    void reduceRaceCount() {
        RacingCarGame racingCarGame = new RacingCarGame(Arrays.asList("a", "b", "c"), 5);
        racingCarGame.orderToReduceRaceCount();

        assertThat(RaceCount.getCount()).isEqualTo(4);
    }
}