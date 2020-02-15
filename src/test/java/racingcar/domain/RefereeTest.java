package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest {
    @Test
    void 가장_멀리_간_자동차의_위치를_반환() {
        Car car1 = new Car("무늬", 4);
        Car car2 = new Car("두강", 4);
        Car car3 = new Car("쿨라임", 3);
        Car car4 = new Car("코일", 2);
        List<Car> cars = Arrays.asList(car1, car2, car3, car4);

        assertThat(Referee.findMaxPosition(cars)).isEqualTo(4);
    }

    @Test
    void 우승자들을_결정() {
        Car car1 = new Car("무늬", 4);
        Car car2 = new Car("두강", 4);
        Car car3 = new Car("쿨라임", 3);
        Car car4 = new Car("코일", 2);
        List<Car> cars = Arrays.asList(car1, car2, car3, car4);

        List<Car> expectedWinners = Arrays.asList(car1, car2);

        assertThat(Referee.getWinners(cars)).isEqualTo(expectedWinners);
    }
}
