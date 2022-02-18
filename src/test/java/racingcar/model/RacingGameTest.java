package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    void isEndTest1() {
        RacingGame racingGame = new RacingGame(new Cars(), 3);
        assertThat(racingGame.isEnd()).isFalse();
    }

    @Test
    void raceRoundTest() {
        RacingGame racingGame = new RacingGame(new Cars(), 3);
        for (int i = 0; i < 3; i++) {
            racingGame.raceRound();
        }
        assertThat(racingGame.isEnd()).isTrue();
    }
}
