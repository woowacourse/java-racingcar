package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarDTO;
import racingcar.domain.RacingGame;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest {

    RacingGame racingGame;

    @BeforeEach
    void initRacingGame() {
        racingGame = new RacingGame();
    }


    @Test
    @DisplayName("시도 횟수에 정수를 입력하지 않는 경우 예외 발생")
    void attemptMustBeInteger() {
        assertThatThrownBy(() -> racingGame.initTotalAttempt("문자"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도 횟수에 음수를 입력한 경우 예외 발생")
    void attemptMustBePositive() {
        assertThatThrownBy(() -> racingGame.initTotalAttempt("-3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력된 시도횟수만큼 반복")
    void repeatedAsAttempt() {
        racingGame.initCarNames(new String[]{"a", "b"});
        racingGame.initTotalAttempt("5");
        List<List<CarDTO>> totalExecutionResult = racingGame.play();

        assertThat(totalExecutionResult.size()).isEqualTo(5);
    }

}
