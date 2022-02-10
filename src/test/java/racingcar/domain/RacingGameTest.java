package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingGameTest {

    private RacingCars racingCars;

    @BeforeEach
    void setUp() {
        racingCars = new RacingCars("pobi,crong,honux");
    }

    @Test
    @DisplayName("게임이 종료되었는지 확인한다.")
    void checkGameEnd() {
        RacingGame game = new RacingGame(racingCars, 5);
        game.race();
        assertTrue(game.isEnd());
    }

    @Test
    @DisplayName("게임이 종료되지 않았는지 확인한다.")
    void checkGameNotEnd() {
        RacingGame game = new RacingGame(racingCars, 5);
        assertFalse(game.isEnd());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("게임을 생성할 때 시도횟수가 0이하이면 예외가 발생한다.")
    void nagativeCount(int count) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new RacingGame(racingCars, count))
            .withMessageMatching("시도횟수는 0이하의 값이 들어올 수 없다.");
    }

    @Test
    @DisplayName("게임이 종료되었는데 race할 경우 exception이 발생한다.")
    void raceEndException() {
        RacingGame game = new RacingGame(racingCars, 5);
        game.race();
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> game.race())
            .withMessageMatching("종료된 게임은 더이상 실행할 수 없다.");
    }
}
