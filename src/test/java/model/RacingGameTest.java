package model;

import static fixture.CarFixture.자동차;
import static fixture.CarFixture.자동차들;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.Test;
import support.MovableNumberGenerator;
import util.NumberGenerator;

class RacingGameTest {
    private final NumberGenerator movableNumberGenerator = new MovableNumberGenerator();

    @Test
    void 중복된_자동차가_존재하지_않으면_예외가_발생하지_않는다() {
        // given
        Car carPobi = 자동차("pobi");
        Car carCrong = 자동차("crong");
        Car carHonux = 자동차("honux");
        List<Car> cars = List.of(carPobi, carCrong, carHonux);

        // when & then
        assertDoesNotThrow(() -> new RacingGame(cars));
    }

    @Test
    void 중복된_자동차가_존재하면_예외가_발생한다() {
        // given
        Car carPobi1 = 자동차("pobi");
        Car carPobi2 = 자동차("pobi");
        Car carHonux = 자동차("honux");
        List<Car> cars = List.of(carPobi1, carPobi2, carHonux);

        // when & then
        assertThatThrownBy(() -> new RacingGame(cars))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 단독_우승자를_찾는다() {
        // given
        Car winner = 자동차("prin");
        Car loser1 = 자동차("mark");
        Car loser2 = 자동차("pobi");
        RacingGame racingGame = 자동차들(winner, loser1, loser2);
        winner.moveForward(movableNumberGenerator);

        // when
        List<String> winners = racingGame.findWinners();

        // then
        assertThat(winners).hasSize(1)
                .contains(winner.getName());
    }

    @Test
    void 공동_우승자를_찾는다() {
        // given
        Car loser = 자동차("prin");
        Car winner1 = 자동차("mark");
        Car winner2 = 자동차("pobi");
        RacingGame racingGame = 자동차들(loser, winner1, winner2);
        winner1.moveForward(movableNumberGenerator);
        winner2.moveForward(movableNumberGenerator);

        // when
        List<String> winners = racingGame.findWinners();

        // then
        assertThat(winners).hasSize(2)
                .contains(winner1.getName(), winner2.getName());
    }
}
