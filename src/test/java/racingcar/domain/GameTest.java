package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.MockRandomNumberGenerator;
import racingcar.exception.RacingGameIsFinishedException;

class GameTest {

    private static final String CAR_1_NAME = "pobi";
    private static final String CAR_2_NAME = "jason";

    @Test
    @DisplayName("시도횟수_이상으로_게임_진행시_예외_발생")
    void proceedTurn_gameOver_case() {
        Game game = new Game(List.of(CAR_1_NAME, CAR_2_NAME), 2, new MockRandomNumberGenerator());
        game.proceedTurn();
        game.proceedTurn();
        assertThatThrownBy(() -> game.proceedTurn())
                .isInstanceOf(RacingGameIsFinishedException.class)
                .hasMessageContaining(RacingGameIsFinishedException.ERROR_MESSAGE);
    }
}
