package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    Cars cars;
    Car car = new Car("test");

    @BeforeEach
    void setUp() {
        cars = new Cars();
    }

    @Test
    @DisplayName("차 추가 테스트")
    void checkAdd() {
        cars.add(car);

        assertThat(cars.getStatus(car)).isEqualTo(0);
    }

    @Test
    @DisplayName("move 실행시 value가 1 증가한다.")
    void checkMove() {
        cars.add(car);
        cars.move(car);

        Long status = cars.getStatus(car);

        assertThat(status).isEqualTo(1L);
    }

    @Test
    @DisplayName("value 가 제일 높은 key를 반환한다.")
    void checkGetWinners() {
        Car fox = new Car("fox");

        cars.add(car);
        cars.add(fox);

        cars.move(fox);

        List<Car> winners = cars.getWinners();

        assertThat(winners).containsExactly(fox);
    }

    @Test
    @DisplayName("value 가 가장 높은 key가 여러개면 모두 반환한다.")
    void checkGetWinnerDraw() {
        Car fox = new Car("fox");

        cars.add(car);
        cars.add(fox);

        cars.move(car);
        cars.move(fox);

        List<Car> winners = cars.getWinners();

        assertThat(winners).containsExactly(car, fox);
    }
}