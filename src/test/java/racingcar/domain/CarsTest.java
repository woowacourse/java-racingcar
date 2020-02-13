package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domian.Car;
import racingcar.domian.Cars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {

    @Test
    void 가장_먼_자동차의_거리() {
        String inputNames = "user1,user2,user3,user4";
        Cars cars = new Cars(inputNames);
        Car testCar = cars.getCars().get(0);
        testCar.move(5);
        assertThat(cars.findMaxPosition()).isEqualTo(1);
    }

    @Test
    void 자동자가_5대_초과로_오는_경우() {
        String names = "user1,user2,user3,user4,user5,user6";
        assertThatThrownBy(() -> {
            new Cars(names);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 5대 초과");
    }
}
