package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest {

    @Test
    @DisplayName("시도 횟수에 음수를 입력한 경우 예외 발생")
    void attemptMustBePositive() {
        assertThatThrownBy(() -> new RacingGame(new String[] {"a"},-3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력된 시도횟수만큼 반복")
    void repeatedAsAttempt() {
        RacingGame racingGame = new RacingGame(new String[]{"a"},5);
        List<ExecutionResult> totalExecutionResult = racingGame.play();

        assertThat(totalExecutionResult.size()).isEqualTo(5);
    }

}
