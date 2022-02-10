package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class CarsTest extends MockRandomGenerator{


    @Test
    void 자동차_우승_성공() {
        Car rickCar = new Car("rick");

        for (int i = 0; i < 3; i++) {
            randomNumberOverFour();
            rickCar.goForward();
        }

        Cars cars = new Cars();
        cars.addCar(new Car("jae"));
        cars.addCar(rickCar);

        assertThat(cars.getWinners()).isEqualTo("rick가 최종 우승 했습니다.");

        closeMockRandom();
    }
}