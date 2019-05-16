package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    RacingGame racingGame;
    String[] carNames;
    int totalRounds;

    @BeforeEach
    void setup() {
        carNames = new String[]{"a", "bb", "ccc", "dddd", "eeeee"};
        totalRounds = 10;
        racingGame = new RacingGame(carNames, totalRounds);
    }

    @Test
    void 횟수불러오기() {
        assertThat(racingGame.getTotalRound()).isEqualTo(totalRounds);
    }

    @Test
    void 자동차들객체리턴() {
        assertThat(racingGame.playOneRound()).isInstanceOf(Cars.class);
    }
}
