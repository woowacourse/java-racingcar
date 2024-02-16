package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class RacingGameTest {
    @Test
    void canRun() {
        RacingGame racingGame = RacingGame.of(Count.from(3), new RandomMovementGenerator(new RandomNumberGenerator()));
        Cars cars = Cars.from(List.of(Car.fromName("pobi"), Car.fromName("kirby")));

        racingGame.playTurn(cars);
        racingGame.playTurn(cars);

        assertThat(racingGame.canRun()).isTrue();
    }
    @Test
    void canNotRun() {
        RacingGame racingGame = RacingGame.of(Count.from(1), new RandomMovementGenerator(new RandomNumberGenerator()));
        Cars cars = Cars.from(List.of(Car.fromName("pobi"), Car.fromName("kirby")));

        racingGame.playTurn(cars);

        assertThat(racingGame.canRun()).isFalse();
    }

    @Test
    void playTurn() {
        MovementGenerator movementGenerator = () -> Movement.MOVE;
        RacingGame racingGame = RacingGame.of(Count.from(2), movementGenerator);
        Cars cars = Cars.from(List.of(Car.fromName("pobi"), Car.fromName("kirby")));

        racingGame.playTurn(cars);
        racingGame.playTurn(cars);

        assertThat(cars.getCars()).contains(Car.of("pobi", 2), Car.of("kirby", 2));
    }
}