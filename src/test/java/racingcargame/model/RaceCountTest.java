package racingcargame.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceCountTest {

    @Test
    @DisplayName("자동차 경부 횟수 초기화 및 경주 횟수 감소 테스트")
    void reduceRaceCount() {
        RaceCount raceCount = new RaceCount(3);
        raceCount.reduceCount();
        raceCount.reduceCount();
        raceCount.reduceCount();

        assertThat(raceCount.isZeroCount()).isTrue();

        raceCount = new RaceCount(2);
        raceCount.reduceCount();

        assertThat(raceCount.isZeroCount()).isFalse();
    }
}