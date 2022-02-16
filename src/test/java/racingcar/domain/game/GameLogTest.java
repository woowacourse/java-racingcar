package racingcar.domain.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.MockRandomNumberGenerator;

class GameLogTest {

    private static final String CAR_1_NAME = "pobi";
    private static final String CAR_2_NAME = "jason";

    private RacingGame racingGame;

    @BeforeEach
    public void setUp() {
        List<String> names = List.of(CAR_1_NAME, CAR_2_NAME);
        racingGame = new RacingGame(names, 4, new MockRandomNumberGenerator());
        racingGame.proceedTurn();
        racingGame.proceedTurn();
        racingGame.proceedTurn();
        racingGame.proceedTurn();
    }

    @ParameterizedTest(name = "{0} 번째 턴 : 포지션 {1}")
    @CsvSource(value = {"1,1", "2,2", "3,2", "4,2"})
    public void 자동차이름으로_특정_턴의_포지션_찾기(int currentTryCount, int position) {
        assertThat(racingGame.getGameLog().getPositionByName(currentTryCount, CAR_1_NAME))
                .isEqualTo(position);
    }

    @Test
    public void 우승자_찾기() {
        assertThat(racingGame.getGameLog().getWinnerCarNames(4))
                .containsExactly(CAR_1_NAME, CAR_2_NAME);
    }
}
