package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    @DisplayName("startGame - 공동우승자 ")
    void startGame() {
        RacingGame racingGame = RacingGame.getFixedNumberRacingGame("joy1,joy2", 1);
        RacingGameResult gameResult = racingGame.startGame();

        assertThat(gameResult.getWinners()).containsExactly(
                new Car(CarName.from("joy1"), 2),
                new Car(CarName.from("joy2"), 2));
    }
}