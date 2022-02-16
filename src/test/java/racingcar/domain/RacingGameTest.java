package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.controller.RacingCarCommander;

public class RacingGameTest {

    private RacingCars racingCars;
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingCars = new RacingCars(new String[]{"pobi", "crong", "honux"}, new RacingCarCommander());
        racingGame = new RacingGame(racingCars, 5);
    }

    @Test
    @DisplayName("게임이 종료되었는지 확인한다.")
    void checkGameEnd() {
        for (int i = 0; i < 5; i++) {
            racingGame.race();
        }
        assertTrue(racingGame.isEnd());
    }

    @Test
    @DisplayName("게임이 종료되었는데 race할 경우 exception이 발생한다.")
    void raceEndException() {
        for (int i = 0; i < 5; i++) {
            racingGame.race();
        }
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> racingGame.race())
            .withMessageMatching("종료된 게임은 더이상 실행할 수 없다.");
    }
}
