package racingcar.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

        String totalExecutionResult = racingGame.play();
        long countOfLines = totalExecutionResult.lines().count();

        // 2(각 반복 이후 구분선을 위한 공백) + 6(woo,to,co -> 각 2번 반복) = 8
        assertThat(countOfLines).isEqualTo(8L);
    }
}
