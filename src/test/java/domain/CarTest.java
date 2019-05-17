package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;


class CarTest {
    @Test
    void 생성자_빈문자열() {
        assertThrows(IllegalArgumentException.class, () -> Car.create(""));
    }

    @Test
    void 생성자_null() {
        assertThrows(IllegalArgumentException.class, () -> Car.create(null));
    }

    @Test
    void 생성자_5글자초과() {
        assertThrows(IllegalArgumentException.class, () -> Car.create("123456"));
    }


    @Test
    void move_포지션이1증가() {
        String name = "car";
        int position = 100;
        Car car = Car.create(name, position, () -> true);

        assertThat(car.move()).isEqualTo(Car.create(name, position + 1));
    }

    @Test
    void move_그대로() {
        String name = "car";
        int position = 100;
        Car car = Car.create(name, position, () -> false);

        assertThat(car.move()).isEqualTo(Car.create(name, position));
    }
}