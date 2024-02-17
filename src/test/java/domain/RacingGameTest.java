package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = Cars.from(List.of(Car.fromName("pobi"), Car.fromName("kirby")));
    }

    @Test
    @DisplayName("횟수가 남아있으면 게임을 진행할 수 있다.")
    void canRun() {
        final RacingGame racingGame = RacingGame.of(Count.from(3), new RandomMovementGenerator(new RandomNumberGenerator()));

        racingGame.playTurn(cars);
        racingGame.playTurn(cars);

        assertThat(racingGame.canRun()).isTrue();
    }
    @Test
    @DisplayName("횟수가 남아있지 않으면 게임을 진행할 수 없다.")
    void canNotRun() {
        final RacingGame racingGame = RacingGame.of(Count.from(1), new RandomMovementGenerator(new RandomNumberGenerator()));

        racingGame.playTurn(cars);

        assertThat(racingGame.canRun()).isFalse();
    }

    @Test
    @DisplayName("게임을 진행하면 이동할 수 있는 경우라면 차들이 움직인다.")
    void playTurn() {
        final MovementGenerator movementGenerator = () -> Movement.MOVE;
        final RacingGame racingGame = RacingGame.of(Count.from(2), movementGenerator);

        racingGame.playTurn(cars);
        racingGame.playTurn(cars);

        assertThat(cars.getCars()).contains(Car.of("pobi", 2), Car.of("kirby", 2));
    }
}