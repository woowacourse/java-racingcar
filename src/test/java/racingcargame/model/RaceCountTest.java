package racingcargame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceCountTest {

    @Test
    @DisplayName("자동차 경주 횟수 - 경기가 끝난 경우")
    void reduceAllRaceCount() {
        RaceCount raceCount = new RaceCount(3);
        raceCount.reduceCount();
        raceCount.reduceCount();
        raceCount.reduceCount();

        assertThat(raceCount.isZeroCount()).isTrue();
    }

    @Test
    @DisplayName("자동차 경주 횟수 - 경기 횟수가 남은 경우")
    void remainRaceCount() {
        RaceCount raceCount = new RaceCount(2);
        raceCount.reduceCount();

        assertThat(raceCount.isZeroCount()).isFalse();
    }
}