package racingcar.domain.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.MockRandomNumberGenerator;
import racingcar.exception.RacingGameIsFinishedException;

public class RacingGameTest {

    private static final String CAR_1_NAME = "pobi";
    private static final String CAR_2_NAME = "jason";

    private RacingGame racingGame;
    private List<String> names;

    @BeforeEach
    public void setUp() {
        names = List.of(CAR_1_NAME, CAR_2_NAME);
    }

    @Test
    public void 시도횟수만큼_게임진행() {
        racingGame = new RacingGame(names, 2, new MockRandomNumberGenerator());
        assertThat(racingGame.isFinished()).isFalse();
        racingGame.proceedTurn();
        racingGame.proceedTurn();
        assertThat(racingGame.isFinished()).isTrue();
    }

    @Test
    public void 시도횟수_이상으로_게임_진행시_예외_발생() {
        racingGame = new RacingGame(names, 1, new MockRandomNumberGenerator());
        racingGame.proceedTurn();
        assertThatThrownBy(() -> racingGame.proceedTurn())
                .isInstanceOf(RacingGameIsFinishedException.class);
    }
}
