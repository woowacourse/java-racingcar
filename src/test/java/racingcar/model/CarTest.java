package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {
    @Test
    void 자동차_객체_만들기_테스트() {
        assertThat(new Car("Pobi")).isEqualTo(new Car("Pobi"));
    }

    @Test
    void 자동차_객체이름_공백_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car("");
        });
    }

    @Test
    void 자동차_객체이름_5자초과_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car("abcdef");
        });
    }

    @Test
    void 자동차_객체이름_NULL_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car(null);
        });
    }

    @Test
    void 정지() {
        Car car = new Car("pobi");
        car.move(3);
        assertThat(car).isEqualTo(new Car("pobi", 0));
    }

    @Test
    void 이동() {
        Car car = new Car("pobi");
        car.move(4);
        assertThat(car).isEqualTo(new Car("pobi", 1));
    }
}
