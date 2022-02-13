package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class CarsTest {
    Cars cars = new Cars(new String[]{});

    @Test
    public void 우승자_확인_() {
        cars.insertCar(new Car("A", 1));
        cars.insertCar(new Car("B", 3));
        cars.insertCar(new Car("C", 4));
        assertThat(cars.getWinner()).contains("C");
    }

    @Test
    public void 다중_우승자_확인() {
        cars.insertCar(new Car("A", 1));
        cars.insertCar(new Car("B", 1));
        cars.insertCar(new Car("C", 1));
        assertThat(cars.getWinner()).contains("A", "B", "C");
    }

    @Test
    public void 자동차_저장_확인() {
        cars = new Cars(new String[]{"A", "B", "C"});
        assertThat(cars.getCars().size()).isEqualTo(3);
    }
}
