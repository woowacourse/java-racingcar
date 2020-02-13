package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domian.Car;
import racingcar.domian.Cars;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    void 가장_먼_자동차의_거리() {
        String inputNames = "user1,user2,user3,user4";
        Cars cars = new Cars(inputNames);
        Car testCar = cars.getCars().get(0);
        testCar.move(5);
        assertThat(cars.findMaxPosition()).isEqualTo(1);
    }

}
