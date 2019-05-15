package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {
    Cars testCars;

    @BeforeEach
    void setUp() {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("a", 101));
        cars.add(new Car("b", 101));
        cars.add(new Car("c", 99));
        testCars = new Cars(cars);
    }

    @Test
    void 최종거리와_같은_자동차이름_반환받기() {
        Car car = new Car("a", 3);
        assertThat(car.sameMaxPositionCarName(3)).isEqualTo("a");
    }

    @Test
    void 우승_거리를_반환받는다() {
        assertThat(new Winners(testCars).decideMaxPosition(testCars.getCars())).isEqualTo(101);
    }
}