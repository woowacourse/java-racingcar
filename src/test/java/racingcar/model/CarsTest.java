package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void 자동차_저장_확인1() {
        Car carA = new Car("A",0);
        cars.insertCar(carA);
        assertEquals(carA, cars.getRacingCars().get(0));
    }

    @Test
    public void 자동차_저장_확인2() {
        Car carA = new Car("A",0);
        Car carB = new Car("B",0);
        cars.insertCar(carA);
        cars.insertCar(carB);
        assertEquals(carB, cars.getRacingCars().get(1));
    }
}
