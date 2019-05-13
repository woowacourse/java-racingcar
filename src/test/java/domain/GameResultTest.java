package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

class GameResultTest {
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = new ArrayList<>();

        cars.add(new Car("pobi"));
        cars.add(new Car("crong"));
    }

    @Test
    void create() {
        assertThat(new GameResult(cars)).isEqualTo(new GameResult(cars));
    }

    @Test
    void getWinners() {
        List<Car> winnerCars = new ArrayList<>();
        winnerCars.add(new Car("pobi"));

        winnerCars.get(0).move(4);
        cars.get(0).move(4);

        GameResult gameResult = new GameResult(cars);
        List<Car> winners = gameResult.getWinners();

        for (int i = 0; i < winnerCars.size(); i++) {
            assertThat(winners.get(i)).isEqualTo(winnerCars.get(i));
        }
    }
}
