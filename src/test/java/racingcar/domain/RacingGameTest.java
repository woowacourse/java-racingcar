package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameTest {
    private static final List<Car> cars = new ArrayList<>();

    @BeforeEach
    void beforeEach() {
        cars.add(new Car("A"));
        cars.add(new Car("B"));
        cars.add(new Car("C"));
        cars.add(new Car("D"));
    }

    @AfterEach
    void afterEach() {
        cars.clear();
    }

    @Test
    @DisplayName("우승자 판단 - 단독")
    void checkSingleWinner() {
        cars.get(0).proceed();
        RacingGame racingGame = new RacingGame(cars);
        assertThat(racingGame.findWinners()).contains(cars.get(0));
    }

    @Test
    @DisplayName("우승자 판단 - 공동 우승")
    void checkCoWinner() {
        cars.get(0).proceed();
        cars.get(1).proceed();
        RacingGame racingGame = new RacingGame(cars);
        assertThat(racingGame.findWinners()).contains(cars.get(0), cars.get(1));
    }
}
