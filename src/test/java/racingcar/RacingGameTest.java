package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.RacingGame;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    private static final int ANY_INT = 1;

    private final Car car1 = new Car("car1");
    private final Car car2 = new Car("car2");
    private final List<Car> cars = new ArrayList<>();
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        cars.add(car1);
        cars.add(car2);
        racingGame = new RacingGame(cars, ANY_INT);
    }

    @Test
    @DisplayName("우승자가 한 명일 때 우승자를 선출한다")
    void getWinnerWhenSingleWinner() {
        car1.move(4);
        car2.move(3);

        assertThat(racingGame.findWinners()).containsExactly(car1);
    }

    @Test
    @DisplayName("우승자가 여러 명일 때 우승자를 선출한다")
    void getWinnersWhenMultipleWinners() {
        car1.move(4);
        car2.move(4);

        assertThat(racingGame.findWinners()).containsExactly(car1, car2);
    }
}
