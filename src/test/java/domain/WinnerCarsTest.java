package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerCarsTest {
    private List<Car> cars = new ArrayList<>();
    private List<Car> winners = new ArrayList<>();

    @BeforeEach
    void setUp() {
        cars.add(new Car("pobi"));
        cars.add(new Car("crong"));
        cars.add(new Car("abc"));
        cars.add(new Car("def"));

        cars.get(1).move(4);
        cars.get(2).move(4);
        cars.get(2).move(4);
        cars.get(3).move(4);
        cars.get(3).move(4);

        winners.add(new Car("abc"));
        winners.add(new Car("def"));

        winners.get(0).move(4);
        winners.get(0).move(4);
        winners.get(1).move(4);
        winners.get(1).move(4);
    }

    @Test
    void determineWinnersTest() {
        WinnerCars.determineWinners(cars);

        for (int i = 0; i < winners.size(); i++) {
            assertThat(WinnerCars.getWinnerCars().get(i)).isEqualTo(winners.get(i));
        }

    }
}
