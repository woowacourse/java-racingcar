package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {
    Cars testCars;

    @BeforeEach
    void setUp() {
        ArrayList<Car> cars = new ArrayList<>(Arrays.asList(new Car("a", 101),
                new Car("b", 101), new Car("c", 99)));
        testCars = new Cars(cars);
    }

    @Test
    void 최종거리와_같은_자동차이름_반환받기() {
        Car car = new Car("a", 3);
        assertThat(car.isSameMaxPosition(3)).isEqualTo(true);
    }

    @Test
    void 우승_거리를_반환받는다() {
        assertThat(new Winners(testCars).decideMaxPosition(testCars.getCars())).isEqualTo(101);
    }
}