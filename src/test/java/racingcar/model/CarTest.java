package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void 자동차_객체_만들기_테스트() {
        assertThat(new Car("Pobi")).isEqualTo(new Car("Pobi"));
    }

    @Test
    void 정지() {
        Car car = new Car("pobi");
        car.moveCarByRandom(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 이동() {
        Car car = new Car("pobi");
        car.moveCarByRandom(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
