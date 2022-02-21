package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    @DisplayName("입력된 시도횟수만큼 반복")
    void repeatedAsAttempt() {
        RacingGame racingGame = new RacingGame(new String[]{"a"},5);
        List<ExecutionResult> totalExecutionResult = racingGame.play();

        assertThat(totalExecutionResult.size()).isEqualTo(5);
    }

}
