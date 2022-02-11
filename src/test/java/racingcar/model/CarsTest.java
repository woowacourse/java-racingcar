package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    Cars cars;

    @BeforeEach
    public void beforeEach() {
        cars = new Cars();
    }

    @Test
    public void 우승자_확인() {
        cars.insertCar(new Car("A", 1, () -> 1));
        cars.insertCar(new Car("B", 3, () -> 1));
        cars.insertCar(new Car("C", 4, () -> 1));
        assertThat(cars.getWinner()).contains("C");
    }

    @Test
    public void 다중_우승자_확인() {
        cars.insertCar(new Car("A", 1, () -> 1));
        cars.insertCar(new Car("B", 1, () -> 1));
        cars.insertCar(new Car("C", 1, () -> 1));
        assertThat(cars.getWinner()).contains("A","B","C");
    }
}
