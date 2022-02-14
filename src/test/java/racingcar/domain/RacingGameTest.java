package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingGameTest {

    private RacingCars createInitCars() {
        return RacingCars.from("pobi,crong,honux");
    }

    @Test
    @DisplayName("게임이 종료되었는지 확인한다.")
    void checkGameEnd() {
        RacingCars racingCars = createInitCars();
        RacingGame racingGame = new RacingGame(racingCars, 1);
        racingGame.race();
        assertTrue(racingGame.isEnd());
    }

    @Test
    @DisplayName("게임이 종료되지 않았는지 확인한다.")
    void checkGameNotEnd() {
        RacingCars racingCars = createInitCars();
        RacingGame racingGame = new RacingGame(racingCars, 5);
        assertFalse(racingGame.isEnd());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("게임을 생성할 때 시도횟수가 0이하이면 예외가 발생한다.")
    void nagativeCount(int count) {
        RacingCars racingCars = createInitCars();
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new RacingGame(racingCars, count))
            .withMessageMatching("시도횟수는 0이하의 값이 들어올 수 없다.");
    }

    @Test
    @DisplayName("게임이 종료되었는데 race할 경우 exception이 발생한다.")
    void raceEndException() {
        RacingCars racingCars = createInitCars();
        RacingGame racingGame = new RacingGame(racingCars, 1);
        racingGame.race();
        assertThatExceptionOfType(UnsupportedOperationException.class)
            .isThrownBy(() -> racingGame.race())
            .withMessageMatching("종료된 게임은 더이상 실행할 수 없다.");
    }

    @Test
    @DisplayName("단독 우승자가 있는 경우 우승자만 반환한다.")
    void oneWinnerNames() {
        // given
        List<RacingCar> racingCars = Arrays.asList(
            new RacingCar(new Name("pobi"), () -> true),
            new RacingCar(new Name("crong"), () -> false),
            new RacingCar(new Name("honux"), () -> false)
        );
        RacingGame racingGame = new RacingGame(new RacingCars(racingCars), 1);

        // when
        racingGame.race();
        List<String> result = racingGame.winnerNames();

        // then
        assertAll(
            () -> assertThat(result.size()).isEqualTo(1),
            () -> assertThat(result).contains("pobi")
        );
    }
}
