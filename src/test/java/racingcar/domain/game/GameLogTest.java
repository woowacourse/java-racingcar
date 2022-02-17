package racingcar.domain.game;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.MockRandomNumberGenerator;
import racingcar.domain.Game;

class GameLogTest {

    private static final String CAR_1_NAME = "pobi";
    private static final String CAR_2_NAME = "jason";

    private Game game;

    @BeforeEach
    public void setUp() {
        List<String> names = List.of(CAR_1_NAME, CAR_2_NAME);
        game = new Game(names, 4, new MockRandomNumberGenerator());
        game.proceedTurn();
        game.proceedTurn();
        game.proceedTurn();
        game.proceedTurn();
    }

    @ParameterizedTest(name = "{0} 번째 턴 : 포지션 {1}")
    @CsvSource(value = {"1,1", "2,2", "3,2", "4,2"})
    public void CAR_1_특정_턴의_포지션_찾기(int currentTryCount, int position) {
        assertThat(game.getGameLog().getPositionByName(currentTryCount, CAR_1_NAME))
                .isEqualTo(position);
    }

    @ParameterizedTest(name = "{0} 번째 턴 : 포지션 {1}")
    @CsvSource(value = {"1,0", "2,0", "3,1", "4,2"})
    public void CAR_2_특정_턴의_포지션_찾기(int currentTryCount, int position) {
        assertThat(game.getGameLog().getPositionByName(currentTryCount, CAR_2_NAME))
                .isEqualTo(position);
    }

    @Test
    public void 우승자_찾기() {
        assertThat(game.getGameLog().getWinnerCarNames(4))
                .containsExactly(CAR_1_NAME, CAR_2_NAME);
    }
}
