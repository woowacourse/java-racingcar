package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.MockRandomNumberGenerator;
import racingcar.exception.RacingGameIsFinishedException;

class GameTest {

    private static final String CAR_1_NAME = "pobi";
    private static final String CAR_2_NAME = "jason";

    private Game game;
    private MockRandomNumberGenerator mockRandomNumberGenerator;

    @BeforeEach
    public void setUp() {
        game = new Game(List.of(CAR_1_NAME, CAR_2_NAME), 3, new MockRandomNumberGenerator());
        mockRandomNumberGenerator = new MockRandomNumberGenerator();
        game.proceedTurn();
        game.proceedTurn();
        game.proceedTurn();
    }

    @Test
    @DisplayName("시도횟수_이상으로_게임_진행시_예외_발생")
    void proceedTurn_gameOver_case() {
        assertThatThrownBy(() -> game.proceedTurn())
                .isInstanceOf(RacingGameIsFinishedException.class)
                .hasMessageContaining(RacingGameIsFinishedException.ERROR_MESSAGE);
    }
}
