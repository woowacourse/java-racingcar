package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class CarsTest {
    Cars cars = new Cars();

    @Test
    public void 우승자_확인_() {
        cars.insertCar(new Car("A", 1));
        cars.insertCar(new Car("B", 3));
        cars.insertCar(new Car("C", 4));
        assertThat(cars.getWinner()).contains("C");
    }

    @Test
    public void moveRound_메소드_확인() {
        cars.insertCar(new Car("A", 1, () -> 1));
        cars.insertCar(new Car("B", 2, () -> 5));
        cars.insertCar(new Car("C", 2, () -> 1));
        cars.moveRound();
        assertThat(cars.getWinner()).contains("B");
        assertThat(cars.getWinner()).doesNotContain("C");
    }

    @Test
    public void 다중_우승자_확인() {
        cars.insertCar(new Car("A", 1));
        cars.insertCar(new Car("B", 1));
        cars.insertCar(new Car("C", 1));
        assertThat(cars.getWinner()).contains("A","B","C");
    }
}
