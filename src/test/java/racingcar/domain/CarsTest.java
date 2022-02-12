package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import racingcar.utils.MockRandomGenerator;

public class CarsTest extends MockRandomGenerator {

    @Test
    void 자동차_우승_1명_성공() {
        Car jaeCar = new Car("jae");
        Car rickCar = new Car("rick");

        for (int i = 0; i < 3; i++) {
            moveCarPosition(rickCar);
        }
        Cars cars = new Cars();
        addTestCarToCars(cars, jaeCar, rickCar);
        assertThat(cars.getWinners()).isEqualTo("rick가 최종 우승 했습니다.");
    }

    @Test
    void 자동차_우승_2명_성공() {
        Car jaeCar = new Car("jae");
        Car rickCar = new Car("rick");

        for (int i = 0; i < 3; i++) {
            moveCarPosition(rickCar, jaeCar);
        }
        Cars cars = new Cars();
        addTestCarToCars(cars, jaeCar, rickCar);
        assertThat(cars.getWinners()).isEqualTo("jae, rick가 최종 우승 했습니다.");
    }

    @AfterEach
    void stopMockRandom() {
        closeMockRandom();
    }


    private void addTestCarToCars(Cars cars, Car... car) {
        for (Car c : car) {
            cars.addCar(c);
        }
    }

    private void moveCarPosition(Car... car) {
        for (Car c : car) {
            randomNumberOverFour();
            c.goForward();
        }
    }
}