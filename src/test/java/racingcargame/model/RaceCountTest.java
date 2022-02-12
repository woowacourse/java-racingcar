package racingcargame.model;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RaceCountTest {

    @Test
    void 입력받은_경주_횟수_테스트() {
        RacingCarGame racingCarGame = new RacingCarGame(Arrays.asList("a", "b", "c"), 4);

        assertThat(RaceCount.getCount()).isEqualTo(4);
    }

    @Test
    void 경주_횟수_감소_테스트() {
        RacingCarGame racingCarGame = new RacingCarGame(Arrays.asList("a", "b", "c"), 5);
        racingCarGame.orderToReduceRaceCount();

        assertThat(RaceCount.getCount()).isEqualTo(4);
    }
}