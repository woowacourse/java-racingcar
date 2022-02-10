package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarsTest extends MockRandomGenerator {


    @Test
    void 자동차_우승_1명_성공() {
        Car jaeCar = new Car("jae");
        Car rickCar = new Car("rick");

        for (int i = 0; i < 3; i++) {
            randomNumberOverFour();
            rickCar.goForward();
        }
        closeMockRandom();
        Cars cars = new Cars();
        cars.addCar(jaeCar);
        cars.addCar(rickCar);

        assertThat(cars.getWinners()).isEqualTo("rick가 최종 우승 했습니다.");
    }

    @Test
    void 자동차_우승_2명_성공() {
        Car jaeCar = new Car("jae");
        Car rickCar = new Car("rick");

        for (int i = 0; i < 3; i++) {
            randomNumberOverFour();
            rickCar.goForward();

            randomNumberOverFour();
            jaeCar.goForward();
        }
        closeMockRandom();
        Cars cars = new Cars();
        cars.addCar(jaeCar);
        cars.addCar(rickCar);

        assertThat(cars.getWinners()).isEqualTo("jae, rick가 최종 우승 했습니다.");
    }
}