package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.MockRandomNumberGenerator;
import racingcar.domain.Game;
import racingcar.exception.RacingGameIsFinishedException;

public class GameTest {

    private static final String CAR_1_NAME = "pobi";
    private static final String CAR_2_NAME = "jason";

    private Game game;
    private List<String> names;

    @BeforeEach
    public void setUp() {
        names = List.of(CAR_1_NAME, CAR_2_NAME);
    }

    @Test
    public void 시도횟수만큼_게임진행() {
        game = new Game(names, 2, new MockRandomNumberGenerator());
        assertThat(game.isFinished()).isFalse();
        game.proceedTurn();
        game.proceedTurn();
        assertThat(game.isFinished()).isTrue();
    }

    @Test
    public void 시도횟수_이상으로_게임_진행시_예외_발생() {
        game = new Game(names, 1, new MockRandomNumberGenerator());
        game.proceedTurn();
        assertThatThrownBy(() -> game.proceedTurn())
                .isInstanceOf(RacingGameIsFinishedException.class);
    }
}
