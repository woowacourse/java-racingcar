package racingcar.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarDTO;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    @DisplayName("올바른 최종우승자 결정")
    public void selectRightWinner() {
    }

    @Test
    @DisplayName("입력된 시도횟수만큼 반복")
    public void repeatedAsAttempt() {
        RacingGame racingGame = new RacingGame();
        racingGame.initCarNames("woo,te,co");
        racingGame.initTotalAttempt("2");

        List<List<CarDTO>> totalExecutionResult = racingGame.play();

        assertThat(totalExecutionResult.size()).isEqualTo(2);
    }
}
