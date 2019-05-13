package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameProgressServiceTest {
    @Test
    void raceByRound() {
        GameMovingStrategy strategy = new GameMovingStrategyMock();
        GameProgressService gameProgressService = new GameProgressService(strategy);
        List<Car> cars = new ArrayList<>();
        List<Car> movingCars = new ArrayList<>();

        cars.add(new Car("pobi"));
        movingCars.add(new Car("pobi"));
        movingCars.get(0).move(4);

        assertThat(gameProgressService.raceByRound(new GameResult(cars))).isEqualTo(new GameResult(movingCars));
    }
}
