package racingcar.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private static Cars cars;

    @BeforeAll
    static void init() {
        Car car1 = new Car("car1");
        car1.move();
        Car car2 = new Car("car2");
        car2.move();
        car2.move();
        Car car3 = new Car("car3");
        car3.move();
        car3.move();
        car3.move();
        cars = new Cars(List.of(car1, car2, car3));
    }

    @DisplayName("여러대의_자동차중_최대_길이_계산")
    @Test
    void calculateLongestDistance() {
        assertThat(cars.calculateLongestDistance()).isEqualTo(3);
    }

    @DisplayName("여러대의_자동차중_우승자_찾기")
    @Test
    void findWinners() {
        assertThat(cars.findWinners(3).get(0)).isEqualTo("car3");
    }
}
