package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @DisplayName("게임 끝 검증 테스트")
    @Test
    void isEndTest() {
        RacingGame racingGame = new RacingGame(new Cars(new String[]{}), 3);
        assertThat(racingGame.isEnd()).isFalse();
    }

    @DisplayName("게임 끝 검증 테스트")
    @Test
    void raceRoundTest() {
        RacingGame racingGame = new RacingGame(new Cars(new String[]{}), 3);
        racingGame.race();
        assertThat(racingGame.getTryCount()).isEqualTo(0);
    }
}
