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

public class RacingGameTest {

    private RacingCars createInitCars() {
        return RacingCars.from("pobi,crong,honux");
    }

    @Test
    @DisplayName("게임이 종료되었는지 확인한다.")
    void checkGameEnd() {
        final RacingCars racingCars = createInitCars();
        final Round finalRound = new Round(1);
        final RacingGame racingGame = new RacingGame(racingCars, finalRound);
        racingGame.race();
        assertTrue(racingGame.isEnd());
    }

    @Test
    @DisplayName("게임이 종료되지 않았는지 확인한다.")
    void checkGameNotEnd() {
        final RacingCars racingCars = createInitCars();
        final Round finalRound = new Round(5);
        final RacingGame racingGame = new RacingGame(racingCars, finalRound);
        assertFalse(racingGame.isEnd());
    }

    @Test
    @DisplayName("게임이 종료되었는데 race할 경우 exception이 발생한다.")
    void raceEndException() {
        final RacingCars racingCars = createInitCars();
        final Round finalRound = new Round(1);
        final RacingGame racingGame = new RacingGame(racingCars, finalRound);
        racingGame.race();
        assertThatExceptionOfType(UnsupportedOperationException.class)
            .isThrownBy(() -> racingGame.race())
            .withMessageMatching("종료된 게임은 더이상 실행할 수 없다.");
    }

    @Test
    @DisplayName("단독 우승자가 있는 경우 우승자만 반환한다.")
    void oneWinnerNames() {
        // given
        final List<RacingCar> racingCars = Arrays.asList(
            new RacingCar(new Name("pobi"), () -> true),
            new RacingCar(new Name("crong"), () -> false),
            new RacingCar(new Name("honux"), () -> false)
        );
        final RacingGame racingGame = new RacingGame(new RacingCars(racingCars), new Round(1));

        // when
        racingGame.race();
        final List<String> result = racingGame.winnerNames();

        // then
        assertAll(
            () -> assertThat(result.size()).isEqualTo(1),
            () -> assertThat(result).contains("pobi")
        );
    }

    @Test
    @DisplayName("우승자가 여러명인 경우 모두 반환한다.")
    void multiWinnerNames() {
        // given
        final List<RacingCar> racingCars = Arrays.asList(
            new RacingCar(new Name("pobi"), () -> true),
            new RacingCar(new Name("crong"), () -> true),
            new RacingCar(new Name("honux"), () -> false)
        );
        final RacingGame racingGame = new RacingGame(new RacingCars(racingCars), new Round(1));

        // when
        racingGame.race();
        final List<String> result = racingGame.winnerNames();

        // then
        assertAll(
            () -> assertThat(result.size()).isEqualTo(2),
            () -> assertThat(result).containsExactly("pobi", "crong")
        );
    }
}
