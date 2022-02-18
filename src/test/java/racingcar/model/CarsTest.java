package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NonAsciiCharacters")
public class CarsTest {
    private final Cars cars = new Cars(new String[]{});

    @DisplayName("우승자 확인 테스트")
    @Test
    void getWinnerTest() {
        cars.insertCar(new Car("A", 1));
        cars.insertCar(new Car("B", 3));
        cars.insertCar(new Car("C", 4));
        assertThat(cars.getWinner()).contains("C");
    }

    @DisplayName("다중 우승자 확인 테스트")
    @Test
    void getWinnersTest() {
        cars.insertCar(new Car("A", 1));
        cars.insertCar(new Car("B", 1));
        cars.insertCar(new Car("C", 1));
        assertThat(cars.getWinner()).contains("A", "B", "C");
    }

    @DisplayName("자동차 저장 확인 테스트1")
    @Test
    void insertCarTest1() {
        Car carA = new Car("A", 0);
        cars.insertCar(carA);
        assertEquals(carA, cars.getCars().get(0));
    }

    @DisplayName("자동차 저장 확인 테스트2")
    @Test
    void insertCarTest2() {
        Car carA = new Car("A", 0);
        Car carB = new Car("B", 0);
        cars.insertCar(carA);
        cars.insertCar(carB);
        assertEquals(carB, cars.getCars().get(1));
    }
}
